import React, { useMemo, useState, useEffect } from "react";
import { Routes, Route, Navigate, Link } from "react-router-dom";
import { ThemeProvider, createTheme, CssBaseline, AppBar, Toolbar, Typography, IconButton, Box, Button } from "@mui/material";
import Brightness4Icon from "@mui/icons-material/Brightness4";
import Brightness7Icon from "@mui/icons-material/Brightness7";
import Login from "./pages/login/index.jsx";
import Register from "./pages/registro/index.jsx";
import Users from "./pages/Usuarios/index.jsx";

const THEME_KEY = "app_theme_mode";


export default function App() {
const [mode, setMode] = useState(() => localStorage.getItem(THEME_KEY) || "dark");
const theme = useMemo(() => createTheme({ palette: { mode } }), [mode]);
const toggleMode = () => setMode(prev => (prev === "light" ? "dark" : "light"));
useEffect(() => { localStorage.setItem(THEME_KEY, mode); }, [mode]);


return (
<ThemeProvider theme={theme}>
    <CssBaseline />
    <TopBar mode={mode} toggleMode={toggleMode} />
    <Box component="main" sx={{ p: 2 }}>
        <Routes>
            <Route path="/" element={<Navigate to="/login" replace />} />
            <Route path="/login" element={<Login />} />
            <Route path="/register" element={<Register />} />
            <Route path="/users" element={<Users />} />
            <Route path="*" element={<Box>404</Box>} />
        </Routes>
    </Box>
</ThemeProvider>
);
}


function TopBar({ mode, toggleMode }) {
return (
<AppBar position="sticky">
    <Toolbar>
        <Typography variant="h6" sx={{ flexGrow: 1 }}>BarberBrossssss</Typography>
        {/* <Button color="inherit" component={Link} to="/login">Login</Button> */}
        <Button color="inherit" component={Link} to="/register">Cadastro</Button>
        <Button color="inherit" component={Link} to="/users">Usuários</Button>
        <IconButton color="inherit" onClick={toggleMode} aria-label="alternar tema" sx={{ ml: 1 }}>
        {mode === "dark" ? <Brightness7Icon /> : <Brightness4Icon />}
        </IconButton>
    </Toolbar>
</AppBar>
);
}