// src/pages/Register.jsx
import React from "react";
import { Box, Paper, Typography, TextField, Button, Stack, Grid } from "@mui/material";
import { useFormik } from "formik";
import * as Yup from "yup";
import { useMask } from "@react-input/mask";
import api from "../../services/index.jsx"

export default function Register() {
  const formik = useFormik({
    initialValues: { nome: "", email: "", senha: "", ddd: "", celular: "" },
    validationSchema: Yup.object({
      nome: Yup.string().required("Obrigatório"),
      email: Yup.string().email("E-mail inválido").required("Obrigatório"),
      senha: Yup.string().min(6, "Min 6").required("Obrigatório"),
      ddd: Yup.string().matches(/^\d{2}$/, "DDD inválido").required("Obrigatório"),
      celular: Yup.string().matches(/^\d{5}-?\d{4}$/, "Celular inválido").required("Obrigatório"),
    }),
    onSubmit: async (values, { setSubmitting, resetForm }) => {
      try {
        // await api.post("/users", values); 
        resetForm();
        alert("Usuário cadastrado! Agora faça login.");
      } finally {
        setSubmitting(false);
      }
    },
  });

  const dddRef = useMask({ mask: "99", replacement: { 9: /\d/ } });
  const celRef = useMask({ mask: "99999-9999", replacement: { 9: /\d/ } });

  return (
    <Box sx={{ maxWidth: 560, mx: "auto", mt: 6 }}>
      <Paper sx={{ p: 3 }}>
        <Typography variant="h5" gutterBottom>Cadastro</Typography>

        <form onSubmit={formik.handleSubmit} noValidate>
          <Stack spacing={2}>
            <TextField
              label="Nome"
              name="nome"
              value={formik.values.nome}
              onChange={formik.handleChange}
              onBlur={formik.handleBlur}
              error={formik.touched.nome && Boolean(formik.errors.nome)}
              helperText={formik.touched.nome && formik.errors.nome}
            />

            <TextField
              label="E-mail"
              name="email"
              type="email"
              value={formik.values.email}
              onChange={formik.handleChange}
              onBlur={formik.handleBlur}
              error={formik.touched.email && Boolean(formik.errors.email)}
              helperText={formik.touched.email && formik.errors.email}
            />

            <TextField
              label="Senha"
              name="senha"
              type="password"
              value={formik.values.senha}
              onChange={formik.handleChange}
              onBlur={formik.handleBlur}
              error={formik.touched.senha && Boolean(formik.errors.senha)}
              helperText={formik.touched.senha && formik.errors.senha}
            />

            <Grid container spacing={2}>
              <Grid item xs={12} sm={4}>
                <TextField
                  label="DDD"
                  name="ddd"
                  value={formik.values.ddd}
                  onChange={(e) => formik.setFieldValue("ddd", e.target.value)}
                  onBlur={formik.handleBlur}
                  error={formik.touched.ddd && Boolean(formik.errors.ddd)}
                  helperText={formik.touched.ddd && formik.errors.ddd}
                  inputRef={dddRef}
                  inputProps={{ inputMode: "numeric" }}
                />
              </Grid>
              <Grid item xs={12} sm={8}>
                <TextField
                  label="Celular"
                  name="celular"
                  value={formik.values.celular}
                  onChange={(e) => formik.setFieldValue("celular", e.target.value)}
                  onBlur={formik.handleBlur}
                  error={formik.touched.celular && Boolean(formik.errors.celular)}
                  helperText={formik.touched.celular && formik.errors.celular}
                  inputRef={celRef}
                  inputProps={{ inputMode: "numeric" }}
                />
              </Grid>
            </Grid>

            <Button variant="contained" type="submit" disabled={formik.isSubmitting}>
              Cadastrar
            </Button>
          </Stack>
        </form>
      </Paper>
    </Box>
  );
}
