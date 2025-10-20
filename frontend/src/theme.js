import { createTheme } from "@mui/material/styles"

const theme = createTheme({
  palette: {
    mode: "dark",
    primary: { main: "#7CE0C3" },
    secondary: { main: "#62B6A5" },
    background: { default: "#0F1419", paper: "#121821" },
    text: { primary: "#E6EDF3", secondary: "#9BA7B4" }
  },
  shape: { borderRadius: 12 },
  components: {
    MuiPaper: { styleOverrides: { root: { backgroundImage: "none" } } },
    MuiCard: { styleOverrides: { root: { backgroundColor: "#161D27", border: "1px solid #1E2733", borderRadius: 16 } } },
    MuiOutlinedInput: { styleOverrides: { root: { borderRadius: 12 } } },
    MuiButton: { styleOverrides: { root: { borderRadius: 12, fontWeight: 700 } } },
    MuiAppBar: { styleOverrides: { root: { backgroundColor: "#0F1419", borderBottom: "1px solid #1E2733" } } }
  },
  typography: {
    fontFamily: ["Inter","Segoe UI","Roboto","Arial","sans-serif"].join(","),
    h6: { fontWeight: 800 }
  }
})

export default theme
