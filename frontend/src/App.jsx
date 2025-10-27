import React from "react"
import { BrowserRouter, Routes, Route, Navigate } from "react-router-dom"
import DashboardLayout from "./layouts/DashboardLayout"
import EmployeesCreate from "./pages/employees/EmployeesCreate"
import EmployeesList from "./pages/employees/EmployeesList"

export default function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route element={<DashboardLayout />}>
          <Route index element={<Navigate to="/funcionarios/visualizar" replace />} />
          <Route path="/funcionarios/cadastrar" element={<EmployeesCreate />} />
          <Route path="/funcionarios/visualizar" element={<EmployeesList />} />
        </Route>
      </Routes>
    </BrowserRouter>
  )
}
