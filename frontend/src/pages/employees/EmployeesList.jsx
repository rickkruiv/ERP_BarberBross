import React from "react"
import { Box, Button, Container, Grid, IconButton, InputAdornment, Paper, Table, TableBody, TableCell, TableHead, TableRow, TextField, Tooltip, Typography } from "@mui/material"
import Search from "@mui/icons-material/Search"
import GetApp from "@mui/icons-material/FileDownloadOutlined"
import PersonAdd from "@mui/icons-material/PersonAddAlt"
import GroupAdd from "@mui/icons-material/GroupAddOutlined"
import Visibility from "@mui/icons-material/VisibilityOutlined"
import Edit from "@mui/icons-material/EditOutlined"
import StatCard from "../../components/StatCard/StatCard"
import { useNavigate } from "react-router-dom"
import { useQuery } from "@tanstack/react-query"
import useDebounce from "../../hooks/useDebounce"
import { fetchEmployees, exportEmployees } from "../../services/employees"
import { toastError, toastSuccess } from "../../services/toast"

export default function EmployeesList() {
  const navigate = useNavigate()
  const [q, setQ] = React.useState("")
  const dq = useDebounce(q, 400)

  const { data, isLoading, isError, refetch } = useQuery({
    queryKey: ["employees", dq],
    queryFn: () => fetchEmployees({ q: dq }),
    staleTime: 30000
  })

  const list = Array.isArray(data) ? data : data?.data || []
  const total = list.length
  const ativos = list.filter(e => e.active === true || e.status?.toString().toUpperCase() === "ATIVO").length
  const inativos = total - ativos

  React.useEffect(() => {
    if (isError) toastError("Falha ao carregar funcionários")
  }, [isError])

  const handleExport = async () => {
    try {
      await exportEmployees({ q: dq })
      toastSuccess("Exportação concluída")
    } catch {
      toastError("Erro ao exportar")
    }
  }

  return (
    <Container maxWidth="xl" sx={{ py: 2 }}>
      <Box sx={{ display: "flex", alignItems: "center", gap: 2, mb: 2 }}>
        <TextField
          value={q}
          onChange={e => setQ(e.target.value)}
          placeholder="Buscar por nome, CPF, e-mail ou cargo..."
          fullWidth
          InputProps={{ startAdornment: <InputAdornment position="start"><Search /></InputAdornment> }}
        />
        <Button onClick={handleExport} variant="outlined" startIcon={<GetApp />}>Exportar</Button>
        <Button onClick={() => navigate("/funcionarios/cadastrar")} variant="contained" startIcon={<PersonAdd />} sx={{ bgcolor: "#62B6A5", color: "#0B1117", "&:hover": { bgcolor: "#58a897" } }}>Novo Funcionário</Button>
      </Box>

      <Grid container spacing={2} sx={{ mb: 2 }}>
        <Grid item><StatCard title="Total de Funcionários" value={total} icon={<GroupAdd />} /></Grid>
        <Grid item><StatCard title="Ativos" value={ativos} dot /></Grid>
        <Grid item><StatCard title="Inativos" value={inativos} dot /></Grid>
      </Grid>

      <Paper sx={{ p: 3, borderRadius: 2, border: "1px solid #1E2733", bgcolor: "#0C1116" }}>
        {isLoading ? (
          <Box sx={{ height: 240, display: "grid", placeItems: "center" }}>
            <Typography>Carregando...</Typography>
          </Box>
        ) : total === 0 ? (
          <Box sx={{ height: 360, display: "grid", placeItems: "center" }}>
            <Box sx={{ textAlign: "center" }}>
              <Box sx={{ width: 64, height: 64, borderRadius: "50%", border: "1px dashed #2b3544", display: "grid", placeItems: "center", mx: "auto", mb: 2 }}>
                <GroupAdd fontSize="large" />
              </Box>
              <Typography variant="h6" fontWeight={800}>Nenhum funcionário cadastrado</Typography>
              <Typography variant="body2" color="text.secondary" sx={{ mb: 2 }}>Comece cadastrando seu primeiro funcionário</Typography>
              <Button onClick={() => navigate("/funcionarios/cadastrar")} variant="contained" startIcon={<PersonAdd />} sx={{ bgcolor: "#62B6A5", color: "#0B1117", "&:hover": { bgcolor: "#58a897" } }}>Cadastrar Funcionário</Button>
            </Box>
          </Box>
        ) : (
          <Table>
            <TableHead>
              <TableRow>
                <TableCell>Nome</TableCell>
                <TableCell>Cargo</TableCell>
                <TableCell>E-mail</TableCell>
                <TableCell>CPF</TableCell>
                <TableCell>Status</TableCell>
                <TableCell align="right">Ações</TableCell>
              </TableRow>
            </TableHead>
            <TableBody>
              {list.map((row) => (
                <TableRow key={row.id || row.uuid}>
                  <TableCell>{row.name || row.nome}</TableCell>
                  <TableCell>{row.role || row.cargo}</TableCell>
                  <TableCell>{row.email}</TableCell>
                  <TableCell>{row.cpf}</TableCell>
                  <TableCell>{(row.active === true || row.status?.toString().toUpperCase() === "ATIVO") ? "Ativo" : "Inativo"}</TableCell>
                  <TableCell align="right">
                    <Tooltip title="Visualizar">
                      <IconButton size="small"><Visibility /></IconButton>
                    </Tooltip>
                    <Tooltip title="Editar">
                      <IconButton size="small"><Edit /></IconButton>
                    </Tooltip>
                  </TableCell>
                </TableRow>
              ))}
            </TableBody>
          </Table>
        )}
      </Paper>
    </Container>
  )
}
