
<link rel="stylesheet" href="/css/UsuarioStyles.css" />


<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>GymFlow - Tu Gimnasio Digital</title>
    <link
            rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css"
    />

</head>
<body>

<%@ include file='barra_tareas.jsp' %>

    <!-- Main Content -->
    <main class="main-content">
        <!-- Hero Section -->
        <section class="hero-section">
            <div class="hero-content">
                <h1>¡Bienvenido a GymFlow!</h1>
                <p>
                    Transforma tu cuerpo y alcanza tus metas fitness con la mejor
                    experiencia de entrenamiento
                </p>

                <div class="hero-stats">
                    <div class="stat-item">
                        <span class="stat-number">500+</span>
                        <span class="stat-label">Miembros Activos</span>
                    </div>
                    <div class="stat-item">
                        <span class="stat-number">50+</span>
                        <span class="stat-label">Clases Semanales</span>
                    </div>
                    <div class="stat-item">
                        <span class="stat-number">24/7</span>
                        <span class="stat-label">Acceso al Gym</span>
                    </div>
                    <div class="stat-item">
                        <span class="stat-number">15+</span>
                        <span class="stat-label">Entrenadores</span>
                    </div>
                </div>
            </div>
        </section>

        <!-- Services Section -->
        <section class="content-section">
            <h2 class="section-title">Nuestros Servicios</h2>
            <p class="section-subtitle">
                Descubre todo lo que GymFlow tiene para ofrecerte
            </p>

            <div class="services-grid">
                <div class="service-card">
                    <div class="service-icon">
                        <i class="fas fa-dumbbell"></i>
                    </div>
                    <h3>Entrenamiento Personal</h3>
                    <p>Sesiones individualizadas con entrenadores certificados</p>
                    <button class="service-btn">Reservar</button>
                </div>

                <div class="service-card">
                    <div class="service-icon">
                        <i class="fas fa-users"></i>
                    </div>
                    <h3>Clases Grupales</h3>
                    <p>Yoga, Pilates, Crossfit, Zumba y más</p>
                    <button class="service-btn">Ver Horarios</button>
                </div>

                <div class="service-card">
                    <div class="service-icon">
                        <i class="fas fa-heartbeat"></i>
                    </div>
                    <h3>Evaluación Física</h3>
                    <p>Análisis completo de tu condición física</p>
                    <button class="service-btn">Agendar</button>
                </div>
            </div>
        </section>

        <!-- Membership Section -->
        <section class="membership-section">
            <h2 class="section-title">Planes de Membresía</h2>
            <p class="section-subtitle">
                Elige el plan perfecto para tus objetivos
            </p>

            <div class="membership-grid">
                <div class="membership-card">
                    <h3>Básico</h3>
                    <div class="membership-price">S/ 99</div>
                    <div class="membership-period">por mes</div>
                    <ul class="membership-features">
                        <li>Acceso al gimnasio 24/7</li>
                        <li>Área de cardio y pesas</li>
                        <li>Vestuarios y duchas</li>
                        <li>Wi-Fi gratuito</li>
                    </ul>
                    <button class="membership-btn">Elegir Plan</button>
                </div>

                <div class="membership-card featured">
                    <h3>Intermedio</h3>
                    <div class="membership-price">S/ 149</div>
                    <div class="membership-period">por mes</div>
                    <ul class="membership-features">
                        <li>Todo lo del plan Básico</li>
                        <li>Clases grupales ilimitadas</li>
                        <li>2 sesiones de entrenamiento personal</li>
                        <li>Acceso a zona VIP</li>
                    </ul>
                    <button class="membership-btn">Elegir Plan</button>
                </div>

                <div class="membership-card">
                    <h3>Premium</h3>
                    <div class="membership-price">S/ 199</div>
                    <div class="membership-period">por mes</div>
                    <ul class="membership-features">
                        <li>Todo lo del plan Intermedio</li>
                        <li>Entrenamiento personal ilimitado</li>
                        <li>Plan nutricional personalizado</li>
                        <li>Acceso a todos los servicios</li>
                    </ul>
                    <button class="membership-btn">Elegir Plan</button>
                </div>
            </div>
        </section>
    </main>
</div>
<script src="navegacion.js"></script>
</body>
</html>
