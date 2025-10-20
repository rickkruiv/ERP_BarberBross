import React from "react"
import { TextField } from "@mui/material"
import { useMask } from "@react-input/mask"

export default function MaskedTextField({ mask, ...rest }) {
  const ref = useMask({ mask, replacement: { 9: /\d/ } })
  return <TextField inputRef={ref} {...rest} />
}
