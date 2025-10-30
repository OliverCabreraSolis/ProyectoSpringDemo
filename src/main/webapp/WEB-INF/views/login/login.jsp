
<link rel="stylesheet" href="/css/LoginStyles.css">



<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login - GymFlow</title>
</head>
<body>
<div class="container" id="container">
    <!-- Panel de login -->
    <div class="form-container login-container">
        <form>
            <h2>Iniciar Sesión</h2>
            <input type="text" placeholder="Usuario" required>
            <input type="password" placeholder="Contraseña" required>
            <button>Ingresar</button>
            <p>¿No tienes cuenta? <a href="#" id="showRegister">Regístrate aquí</a></p>
        </form>
    </div>

    <!-- Panel de registro -->
    <div class="form-container register-container">
        <form>
            <h2>Registro de Cliente</h2>
            <input type="text" placeholder="Nombre completo" required>
            <input type="email" placeholder="Correo" required>
            <input type="password" placeholder="Contraseña" required>
            <button>Registrar</button>
            <p>¿Ya tienes cuenta? <a href="#" id="showLogin">Inicia sesión</a></p>
        </form>
    </div>

    <!-- Panel animado lateral -->
    <div class="overlay-container">
        <div class="overlay">
            <div class="overlay-panel overlay-left">
                <h2>¡Bienvenido de nuevo!</h2>
                <p>Accede con tus credenciales para entrenar con nosotros.</p>
            </div>
            <div class="overlay-panel overlay-right">
                <h2>¡Únete al Gym!</h2>
                <p>Crea tu cuenta y empieza tu camino fitness 💪.</p>
            </div>
        </div>
    </div>
</div>

<script src="LoginScript.js"></script>
</body>
</html>
