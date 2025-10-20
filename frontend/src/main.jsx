import React from "react"
import { createRoot } from "react-dom/client"
import { CssBaseline, ThemeProvider } from "@mui/material"
import { ToastContainer } from "react-toastify"
import "react-toastify/dist/ReactToastify.css"
import App from "./App"
import theme from "./theme"
import "./styles.css"

const root = createRoot(document.getElementById("root"))
root.render(
  <ThemeProvider theme={theme}>
    <CssBaseline />
    <App />
    <ToastContainer position="bottom-left" theme="dark" />
  </ThemeProvider>
)
