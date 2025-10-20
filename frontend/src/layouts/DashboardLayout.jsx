import React from "react"
import { Outlet } from "react-router-dom"
import { AppBar, Box, Container, IconButton, Toolbar, Typography } from "@mui/material"
import MenuIcon from "@mui/icons-material/Menu"
import TopbarUser from "../modules/TopbarUser"
import Sidebar from "../modules/Sidebar"

export default function DashboardLayout() {
  const [open, setOpen] = React.useState(true)
  return (
    <Box sx={{ display: "flex", minHeight: "100vh", bgcolor: "background.default" }}>
      <Sidebar open={open} onToggle={() => setOpen(v => !v)} />
      <Box sx={{ flex: 1, display: "flex", flexDirection: "column" }}>
        <AppBar position="sticky" elevation={0}>
          <Toolbar sx={{ gap: 1 }}>
            <IconButton onClick={() => setOpen(v => !v)}>
              <MenuIcon />
            </IconButton>
            <Typography variant="h6" sx={{ flexGrow: 1 }}>Cadastro de Funcionários</Typography>
            <TopbarUser />
          </Toolbar>
        </AppBar>
        <Container sx={{ py: 3, flex: 1 }}>
          <Outlet />
        </Container>
      </Box>
    </Box>
  )
}
