function updateNavbar() {
    const navbar = document.getElementById("navbar");
    const username = localStorage.getItem("username") || "Desconectado"; // Fallback a "Guest" si no hay usuario

    // Limpiar el navbar
    navbar.innerHTML = "";

    if (username !== "Desconectado") { // Usuario logeado
        navbar.innerHTML = `
            <div class="container px-5">
                <a class="navbar-brand" href="index.html">
                     <img src="img/pucmm_logo.png" alt="PUCMM Logo" height="40">
                </a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
                <div class="collapse navbar-collapse" id="navbarResponsive">
                    <ul class="navbar-nav ms-auto">
                        <li class="nav-item"><a class="nav-link" href="document_new.html">NUEVO REGISTRO</a></li>
                        <li class="nav-item"><a class="nav-link" href="document_show.html">REGISTROS</a></li>
                        <li class="nav-item"><a class="nav-link" href="document_unsynced.html">REGISTROS LOCALES</a></li>
                        <li class="nav-item"><a class="nav-link" href="user_new.html">NUEVO USUARIO</a></li>
                        <li class="nav-item"><a id="connection-status" class="nav-link" href="document_new_offline.html">REGISTRO OFFLINE</a></li>
                        <li class="nav-item"><a id="nav-username" class="nav-link" href="#">${username.toUpperCase()}</a></li>
                        <li class="nav-item"><a id="cerrarSesion" class="nav-link" href="/logout.html">CERRAR SESION</a></li>
                    </ul>
                </div>
            </div>
        `;
    } else { // Usuario no logeado
        navbar.innerHTML = `
            <div class="container px-5">
                <a class="navbar-brand" href="#top">
                    <img src="https://www.pucmm.edu.do/_catalogs/masterpage/PUCMM-Pincipal/img/logo.png" alt="PUCMM Logo" height="40">
                </a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
                <div class="collapse navbar-collapse" id="navbarResponsive">
                    <ul class="navbar-nav ms-auto">
                        <li class="nav-item"><a class="nav-link" href="user_new.html">REGISTRARSE</a></li>
                        <li class="nav-item"><a class="nav-link" href="login.html">INICIAR SESION</a></li>
                    </ul>
                </div>
            </div>
        `;
    }
}

// Actualizar el navbar al cargar la página
window.onload = function() {
    updateNavbar();

};