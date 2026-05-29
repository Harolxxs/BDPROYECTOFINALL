<%-- 
    Document   : principal
    Created on : 23/04/2026, 10:15:48 p. m.
    Author     : harol
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Autofiel S.A</title>
    <style>
        * { margin: 0; padding: 0; box-sizing: border-box; }

        body {
            font-family: 'Segoe UI', Arial, sans-serif;
            background: linear-gradient(135deg, #1a1a2e 0%, #16213e 50%, #0f3460 100%);
            min-height: 100vh;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
        }

        .header {
            text-align: center;
            margin-bottom: 50px;
        }

        .header h1 {
            color: #ffffff;
            font-size: 42px;
            font-weight: 700;
            letter-spacing: 2px;
            text-transform: uppercase;
        }

        .header p {
            color: #a0aec0;
            font-size: 16px;
            margin-top: 8px;
            letter-spacing: 1px;
        }

        .header .linea {
            width: 80px;
            height: 4px;
            background: linear-gradient(90deg, #e94560, #0f3460);
            margin: 15px auto 0;
            border-radius: 2px;
        }

        .cards {
            display: flex;
            gap: 25px;
            flex-wrap: wrap;
            justify-content: center;
            max-width: 900px;
        }

        .card {
            background: rgba(255, 255, 255, 0.05);
            border: 1px solid rgba(255, 255, 255, 0.1);
            border-radius: 16px;
            padding: 35px 30px;
            width: 200px;
            text-align: center;
            text-decoration: none;
            color: #ffffff;
            transition: all 0.3s ease;
            backdrop-filter: blur(10px);
        }

        .card:hover {
            background: rgba(255, 255, 255, 0.12);
            border-color: rgba(233, 69, 96, 0.6);
            transform: translateY(-8px);
            box-shadow: 0 20px 40px rgba(233, 69, 96, 0.2);
        }

        .card .icono {
            font-size: 48px;
            margin-bottom: 15px;
            display: block;
        }

        .card .titulo {
            font-size: 16px;
            font-weight: 600;
            letter-spacing: 0.5px;
        }

        .card .subtitulo {
            font-size: 12px;
            color: #a0aec0;
            margin-top: 6px;
        }

        .card.clientes:hover { border-color: rgba(76, 175, 80, 0.6); box-shadow: 0 20px 40px rgba(76, 175, 80, 0.2); }
        .card.vendedores:hover { border-color: rgba(33, 150, 243, 0.6); box-shadow: 0 20px 40px rgba(33, 150, 243, 0.2); }
        .card.autos:hover { border-color: rgba(255, 87, 34, 0.6); box-shadow: 0 20px 40px rgba(255, 87, 34, 0.2); }
        .card.ventas:hover { border-color: rgba(156, 39, 176, 0.6); box-shadow: 0 20px 40px rgba(156, 39, 176, 0.2); }

        .footer {
            margin-top: 60px;
            color: #4a5568;
            font-size: 13px;
            letter-spacing: 1px;
        }
    </style>
</head>
<body>

    <div class="header">
        <h1>🚗 Autofiel S.A</h1>
        <p>Sistema de Gestión de Concesionario</p>
        <div class="linea"></div>
    </div>

    <div class="cards">
        <a href="index.jsp" class="card clientes">
            <span class="icono">👤</span>
            <div class="titulo">Clientes</div>
            <div class="subtitulo">Registrar y ver clientes</div>
        </a>

        <a href="vendedor.jsp" class="card vendedores">
            <span class="icono">🧑‍💼</span>
            <div class="titulo">Vendedores</div>
            <div class="subtitulo">Registrar y ver vendedores</div>
        </a>

        <a href="autoo.jsp" class="card autos">
            <span class="icono">🚙</span>
            <div class="titulo">Autos</div>
            <div class="subtitulo">Registrar y ver autos</div>
        </a>

        <a href="venta.jsp" class="card ventas">
            <span class="icono">💰</span>
            <div class="titulo">Ventas</div>
            <div class="subtitulo">Registrar y ver ventas</div>
        </a>
    </div>

    <div class="footer">© 2026 Autofiel S.A — Todos los derechos reservados</div>

</body>
</html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>CONCESIONARIO AUTOFIEL S.A</h1>
        	<ul>
		
		<li><a href="index.jsp">Registrar Cliente</a></li>
                <li><a href="vendedor.jsp">Registrar vendedor</a></li>
                <li><a href="autoo.jsp">Registrar auto</a></li>
	</ul>
    </body>
</html>

