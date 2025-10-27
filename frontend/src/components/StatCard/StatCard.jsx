import React from "react"
import { Box, Typography } from "@mui/material"

export default function StatCard({ title, value, icon, dot }) {
  return (
    <Box sx={{ p: 2.5, borderRadius: 2, border: "1px solid #1E2733", bgcolor: "#0C1116", display: "flex", alignItems: "center", gap: 2, minWidth: 280 }}>
      <Box sx={{ flex: 1 }}>
        <Typography variant="body2" color="text.secondary">{title}</Typography>
        <Typography variant="h5" fontWeight={800}>{value}</Typography>
      </Box>
      <Box sx={{ width: 44, height: 44, borderRadius: "50%", display: "grid", placeItems: "center", bgcolor: "rgba(124,224,195,.14)" }}>
        {dot ? <Box sx={{ width: 10, height: 10, borderRadius: "50%", bgcolor: "primary.main" }} /> : icon}
      </Box>
    </Box>
  )
}
