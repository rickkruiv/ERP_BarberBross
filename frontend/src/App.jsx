import React from "react"
import { RouterProvider, createBrowserRouter } from "react-router-dom"
import DashboardLayout from "./layouts/DashboardLayout"
import EmployeesCreate from "./pages/employees/EmployeesCreate"

const router = createBrowserRouter([
  {
    path: "/",
    element: <DashboardLayout />,
    children: [
      { path: "/funcionarios/cadastrar", element: <EmployeesCreate /> }
    ]
  }
])

export default function App() {
  return <RouterProvider router={router} />
}
