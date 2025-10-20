import React from "react"
import { Drawer, Toolbar, Box, Typography, List, ListItemButton, ListItemIcon, ListItemText, Collapse } from "@mui/material"
import DashboardIcon from "@mui/icons-material/Dashboard"
import PeopleIcon from "@mui/icons-material/People"
import AddCircleOutlineIcon from "@mui/icons-material/AddCircleOutline"
import VisibilityIcon from "@mui/icons-material/Visibility"
import Inventory2Icon from "@mui/icons-material/Inventory2"
import WorkIcon from "@mui/icons-material/Work"
import EventAvailableIcon from "@mui/icons-material/EventAvailable"
import SettingsIcon from "@mui/icons-material/Settings"
import { NavLink } from "react-router-dom"

const w = 260

function Group({ icon, label, children }) {
  const [open, setOpen] = React.useState(label === "Funcionários")
  return (
    <>
      <ListItemButton onClick={() => setOpen(o => !o)}>
        <ListItemIcon>{icon}</ListItemIcon>
        <ListItemText primary={label} />
      </ListItemButton>
      <Collapse in={open} timeout="auto" unmountOnExit>
        <List component="div" disablePadding sx={{ pl: 4 }}>{children}</List>
      </Collapse>
    </>
  )
}

export default function Sidebar({ open }) {
  return (
    <Drawer variant="persistent" open={open} sx={{ width: w, flexShrink: 0, "& .MuiDrawer-paper": { width: w, boxSizing: "border-box", borderRight: "1px solid #1E2733", bgcolor: "background.default" } }}>
      <Toolbar sx={{ gap: 1, borderBottom: "1px solid #1E2733" }}>
        <Box sx={{ width: 36, height: 36, borderRadius: 1.5, bgcolor: "#161D27", display: "grid", placeItems: "center", fontWeight: 900 }}>BB</Box>
        <Box>
          <Typography variant="subtitle1" fontWeight={800}>BarberBross</Typography>
          <Typography variant="caption" color="text.secondary">Sistema ERP</Typography>
        </Box>
      </Toolbar>
      <List>
        <ListItemButton>
          <ListItemIcon><DashboardIcon /></ListItemIcon>
          <ListItemText primary="Dashboard" />
        </ListItemButton>
        <Group icon={<PeopleIcon />} label="Funcionários">
          <ListItemButton component={NavLink} to="/funcionarios/cadastrar">
            <ListItemIcon><AddCircleOutlineIcon /></ListItemIcon>
            <ListItemText primary="Cadastrar" />
          </ListItemButton>
          <ListItemButton>
            <ListItemIcon><VisibilityIcon /></ListItemIcon>
            <ListItemText primary="Visualizar" />
          </ListItemButton>
        </Group>
        <Group icon={<WorkIcon />} label="Serviços">
          <ListItemButton><ListItemText primary="Lista" /></ListItemButton>
        </Group>
        <Group icon={<Inventory2Icon />} label="Produtos">
          <ListItemButton><ListItemText primary="Estoque" /></ListItemButton>
        </Group>
        <Group icon={<EventAvailableIcon />} label="Agenda">
          <ListItemButton><ListItemText primary="Calendário" /></ListItemButton>
        </Group>
        <Group icon={<SettingsIcon />} label="Configurações">
          <ListItemButton><ListItemText primary="Preferências" /></ListItemButton>
        </Group>
      </List>
    </Drawer>
  )
}
