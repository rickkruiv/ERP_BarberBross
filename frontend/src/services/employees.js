import api from "./api"

export async function fetchEmployees(params) {
  const { data } = await api.get("/employees", { params })
  return data
}

export async function exportEmployees(params) {
  const res = await api.get("/employees/export", { params, responseType: "blob" })
  const url = window.URL.createObjectURL(new Blob([res.data]))
  const a = document.createElement("a")
  a.href = url
  a.download = "funcionarios.csv"
  document.body.appendChild(a)
  a.click()
  a.remove()
  window.URL.revokeObjectURL(url)
}
