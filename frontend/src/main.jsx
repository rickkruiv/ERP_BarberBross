import React from "react";
import { createRoot } from "react-dom/client";
import { HashRouter } from "react-router-dom";
import { QueryClient, QueryClientProvider } from "@tanstack/react-query";
import App from "./App.jsx";


const qc = new QueryClient();
const root = createRoot(document.getElementById("root"));
root.render(
<React.StrictMode>
    <QueryClientProvider client={qc}>
        <HashRouter>
            <App />
        </HashRouter>
    </QueryClientProvider>
</React.StrictMode>
);