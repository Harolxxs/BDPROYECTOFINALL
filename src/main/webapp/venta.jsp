<%-- 
    Document   : venta
    Created on : 28/05/2026, 10:51:19 p. m.
    Author     : Malguz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="modelo.Venta_1"%>
<%@page import="modelo.Auto_1"%>
<%@page import="modelo.Cliente_1"%>
<%@page import="modelo.Vendedor_1"%>
<%@page import="controlador.Venta_1JpaController"%>
<%@page import="controlador.Auto_1JpaController"%>
<%@page import="controlador.Cliente_1JpaController"%>
<%@page import="controlador.Vendedor_1JpaController"%>
<%@page import="jakarta.persistence.EntityManagerFactory"%>
<%@page import="jakarta.persistence.Persistence"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%
    EntityManagerFactory emf = (EntityManagerFactory) application.getAttribute("emf");
    if (emf == null) {
        emf = Persistence.createEntityManagerFactory(
            "com.mycompany_AUTOFIELS.A_war_1.0-SNAPSHOTPU"
        );
        application.setAttribute("emf", emf);
    }

    Venta_1JpaController ventaController       = new Venta_1JpaController(emf);
    Auto_1JpaController autoController         = new Auto_1JpaController(emf);
    Cliente_1JpaController clienteController   = new Cliente_1JpaController(emf);
    Vendedor_1JpaController vendedorController = new Vendedor_1JpaController(emf);

    String mensaje = "";
    boolean exito  = false;

    if ("POST".equals(request.getMethod())) {
        try {
            Long idAuto      = Long.parseLong(request.getParameter("idAuto"));
            Long idCliente   = Long.parseLong(request.getParameter("idCliente"));
            Long idVendedor  = Long.parseLong(request.getParameter("idVendedor"));
            String fechaStr  = request.getParameter("fechaVenta");
            double valorVenta = Double.parseDouble(request.getParameter("valorVenta"));
            String formaPago = request.getParameter("formaPago");

            // Validacion 1: ¿Existe el auto?
            Auto_1 auto = autoController.findAuto_1(idAuto);
            if (auto == null) {
                mensaje = "Error: El auto con ID " + idAuto + " no existe.";
            }
            // Validacion 2: ¿El auto ya fue vendido?
            else if (ventaController.autoYaVendido(idAuto)) {
                mensaje = "Error: El auto con ID " + idAuto + " ya fue vendido.";
            }
            // Validacion 3: ¿Existe el cliente?
            else if (clienteController.findCliente_1(idCliente) == null) {
                mensaje = "Error: El cliente con ID " + idCliente + " no existe.";
            }
            // Validacion 4: ¿Existe el vendedor?
            else if (vendedorController.findVendedor_1(idVendedor) == null) {
                mensaje = "Error: El vendedor con ID " + idVendedor + " no existe.";
            }
            else {
                // Todo válido, registrar la venta
                Date fechaVenta = new SimpleDateFormat("yyyy-MM-dd").parse(fechaStr);
                Venta_1 v = new Venta_1(idAuto, idCliente, idVendedor, fechaVenta, valorVenta, formaPago);
                ventaController.create(v);
                mensaje = "Venta registrada correctamente.";
                exito = true;
            }
        } catch (Exception e) {
            mensaje = "Error inesperado: " + e.getMessage();
        }
    }

    List<Venta_1> ventas = ventaController.findVenta_1Entities();
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Gestión de Ventas</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 30px; background: #f4f4f4; }
        h2   { color: #333; }
        .form-box { background: white; padding: 20px; border-radius: 8px;
                    box-shadow: 0 2px 6px rgba(0,0,0,0.1); max-width: 450px; }
        input[type=text], input[type=number], input[type=date], select {
            width: 100%; padding: 8px; margin: 6px 0 12px 0;
            border: 1px solid #ccc; border-radius: 4px; box-sizing: border-box;
        }
        label { font-weight: bold; font-size: 14px; }
        button { background: #9C27B0; color: white; padding: 10px 20px;
                 border: none; border-radius: 4px; cursor: pointer; font-size: 15px; }
        button:hover { background: #7B1FA2; }
        .mensaje-ok  { color: green; font-weight: bold; margin: 12px 0; }
        .mensaje-err { color: red;   font-weight: bold; margin: 12px 0; }
        table { width: 100%; border-collapse: collapse; margin-top: 25px;
                background: white; border-radius: 8px; overflow: hidden;
                box-shadow: 0 2px 6px rgba(0,0,0,0.1); }
        th { background: #9C27B0; color: white; padding: 10px; text-align: left; }
        td { padding: 9px 10px; border-bottom: 1px solid #eee; }
        tr:hover td { background: #f9f9f9; }
        .back { margin-bottom: 20px; display: inline-block;
                color: #9C27B0; text-decoration: none; font-weight: bold; }
    </style>
</head>
<body>

<a class="back" href="principal.jsp">← Volver al menú</a>
<h2>Registrar Venta</h2>
<div class="form-box">
    <form method="POST" action="venta.jsp">
        <label>ID Auto:</label>
        <input type="number" name="idAuto" required />

        <label>ID Cliente:</label>
        <input type="number" name="idCliente" required />

        <label>ID Vendedor:</label>
        <input type="number" name="idVendedor" required />

        <label>Fecha de Venta:</label>
        <input type="date" name="fechaVenta" required />

        <label>Valor de Venta ($):</label>
        <input type="number" name="valorVenta" step="0.01" min="0" required />

        <label>Forma de Pago:</label>
        <select name="formaPago">
            <option value="Contado">Contado</option>
            <option value="Credito">Crédito</option>
        </select>

        <button type="submit">Registrar Venta</button>
    </form>
    <% if (!mensaje.isEmpty()) { %>
        <p class="<%= exito ? "mensaje-ok" : "mensaje-err" %>"><%= mensaje %></p>
    <% } %>
</div>

<h2>Ventas Registradas (<%= ventas.size() %>)</h2>
<table>
    <tr>
        <th>ID</th><th>ID Auto</th><th>ID Cliente</th><th>ID Vendedor</th>
        <th>Fecha</th><th>Valor</th><th>Forma Pago</th>
    </tr>
    <% 
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    for (Venta_1 v : ventas) { %>
    <tr>
        <td><%= v.getIdVenta() %></td>
        <td><%= v.getIdAuto() %></td>
        <td><%= v.getIdCliente() %></td>
        <td><%= v.getIdVendedor() %></td>
        <td><%= sdf.format(v.getFechaVenta()) %></td>
        <td>$<%= String.format("%,.2f", v.getValorVenta()) %></td>
        <td><%= v.getFormaPago() %></td>
    </tr>
    <% } %>
    <% if (ventas.isEmpty()) { %>
    <tr><td colspan="7" style="text-align:center;color:#999;">No hay ventas registradas.</td></tr>
    <% } %>
</table>
</body>
</html>