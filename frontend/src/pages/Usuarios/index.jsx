import React, { useState } from "react";
import {
  Box, Paper, Typography, Table, TableBody, TableCell, TableContainer,
  TableHead, TableRow, IconButton, Menu, MenuItem, Snackbar, Alert,
  Stack, Button, CircularProgress
} from "@mui/material";
import MoreVertIcon from "@mui/icons-material/MoreVert";
import { useQuery, useMutation, useQueryClient } from "@tanstack/react-query";
import api from "../../services/index.jsx"

export default function Users() {
  const qc = useQueryClient();
  const [menuAnchor, setMenuAnchor] = useState(null);
  const [selected, setSelected] = useState(null);
  const [snack, setSnack] = useState({ open: false, msg: "", sev: "success" });


  const { data, isLoading } = useQuery({
    queryKey: ["users"],
    queryFn: async () => (await api.get("/clientes")).data,
  });

  const mCreate = useMutation({
    mutationFn: async (body) => (await api.post("/clientes", body)).data,
    onSuccess: () => {
      qc.invalidateQueries({ queryKey: ["users"] });
      setSnack({ open: true, msg: "Usuário criado", sev: "success" });
    },
  });

  
  const mEdit = useMutation({
    mutationFn: async ({ id, body }) => (await api.put("/clientes", body)).data,
    onSuccess: () => {
      qc.invalidateQueries({ queryKey: ["users"] });
      setSnack({ open: true, msg: "Usuário atualizado", sev: "success" });
    },
  });

  
  const mDelete = useMutation({
    mutationFn: async (id) => (await api.delete("/clientes")).data,
    onSuccess: () => {
      qc.invalidateQueries({ queryKey: ["users"] });
      setSnack({ open: true, msg: "Usuário excluído", sev: "success" });
    },
  });

  const openMenu = Boolean(menuAnchor);
  const handleMenu = (evt, row) => { setMenuAnchor(evt.currentTarget); setSelected(row); };
  const closeMenu = () => setMenuAnchor(null);

  const handleNovo = async () => {
    const nome = prompt("Nome:");
    if (!nome) return;
    const email = prompt("E-mail:");
    if (!email) return;
    const senha = prompt("Senha:");
    if (!senha) return;
    mCreate.mutate({ nome, email, senha });
  };

  const onEditar = async () => {
    closeMenu();
    if (!selected) return;
    const novoNome = prompt("Novo nome:", selected.nome ?? "");
    if (novoNome && novoNome !== selected.nome) {
      mEdit.mutate({ id: selected.id, body: { nome: novoNome } });
    }
  };

  const onExcluir = () => { closeMenu(); if (selected) mDelete.mutate(selected.id); };

  return (
    <Box sx={{ maxWidth: 900, mx: "auto", mt: 4 }}>
      <Paper sx={{ p: 2 }}>
        <Stack direction="row" alignItems="center" justifyContent="space-between" sx={{ mb: 1 }}>
          <Typography variant="h5">Usuários</Typography>
          <Button
            variant="contained"
            onClick={handleNovo}
            disabled={mCreate.isPending}
          >
            {mCreate.isPending ? "Salvando..." : "Novo"}
          </Button>
        </Stack>

        {isLoading ? (
          <Box sx={{ p: 4, textAlign: "center" }}>
            <CircularProgress />
          </Box>
        ) : (
          <TableContainer>
            <Table size="medium">
              <TableHead>
                <TableRow>
                  <TableCell>ID</TableCell>
                  <TableCell>Nome</TableCell>
                  <TableCell>E-mail</TableCell>
                  <TableCell align="right">Ações</TableCell>
                </TableRow>
              </TableHead>
              <TableBody>
                {(data || []).map((row) => (
                  <TableRow key={row.id} hover>
                    <TableCell>{row.id}</TableCell>
                    <TableCell>{row.nome}</TableCell>
                    <TableCell>{row.email}</TableCell>
                    <TableCell align="right">
                      <IconButton onClick={(e) => handleMenu(e, row)} aria-label={`mais ações de ${row.nome}`}>
                        <MoreVertIcon />
                      </IconButton>
                    </TableCell>
                  </TableRow>
                ))}
                {!data?.length && (
                  <TableRow>
                    <TableCell colSpan={4} align="center">Sem usuários</TableCell>
                  </TableRow>
                )}
              </TableBody>
            </Table>
          </TableContainer>
        )}
      </Paper>

      <Menu
        anchorEl={menuAnchor}
        open={openMenu}
        onClose={closeMenu}
        anchorOrigin={{ vertical: "bottom", horizontal: "right" }}
        transformOrigin={{ vertical: "top", horizontal: "right" }}
      >
        <MenuItem onClick={onEditar} disabled={mEdit.isPending}>Editar</MenuItem>
        <MenuItem onClick={onExcluir} disabled={mDelete.isPending}>Excluir</MenuItem>
      </Menu>

      <Snackbar
        open={snack.open}
        autoHideDuration={3000}
        onClose={() => setSnack({ ...snack, open: false })}
      >
        <Alert severity={snack.sev} variant="filled">{snack.msg}</Alert>
      </Snackbar>
    </Box>
  );
}