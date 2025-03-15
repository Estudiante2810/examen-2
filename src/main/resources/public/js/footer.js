function updateFooter() {
    const footer = document.getElementById("footer");
    if (footer) { // Verificar que el elemento exista
        footer.innerHTML = `
            <footer class="bg-dark text-white py-5">
                <div class="container">
                    <div class="row">
                        <div class="col-md-3 mb-4">
                            <h5>Campus de Santiago</h5>
                            <ul class="list-unstyled">
                                <li>Autopista Duarte Km 1 1/2</li>
                                <li>Santiago, República Dominicana</li>
                                <li>Tel.: (809) 580-1962</li>
                            </ul>
                        </div>
                        <div class="col-md-3 mb-4">
                            <h5>Campus de Santo Domingo</h5>
                            <ul class="list-unstyled">
                                <li>Abraham Lincoln esq. Simón Bolívar</li>
                                <li>Santo Domingo, República Dominicana</li>
                                <li>Tel.: (809) 580-1962</li>
                            </ul>
                        </div>
                        <div class="col-md-3 mb-4">
                            <h5>Extensión Puerto Plata</h5>
                            <ul class="list-unstyled">
                                <li>Calle Separación No.2</li>
                                <li>Puerto Plata, República Dominicana</li>
                                <li>Tel.: (809) 586-2060</li>
                            </ul>
                        </div>
                        <div class="col-md-3 mb-4">
                            <h5>Línea de Atención</h5>
                            <p><i class="fa fa-phone"></i> <a href="tel:(809)2001962" class="text-white text-decoration-none">1(809) 200 1962</a></p>
                            <p><i class="fa fa-whatsapp"></i> <a href="https://wa.me/18097231960" class="text-white text-decoration-none">(809) 580 1962</a></p>
                            <p><i class="fa fa-envelope"></i> <a href="mailto:info@pucmm.edu.do" class="text-white text-decoration-none">info@pucmm.edu.do</a></p>
                            <p><i class="fa fa-envelope"></i> <a href="/formulario-quejas" class="text-white text-decoration-none">Reclamaciones y sugerencias</a></p>
                            <div class="d-flex gap-2 mt-3">
                                <a href="http://www.facebook.com/pucmm/" class="text-white"><i class="fa fa-facebook fa-2x"></i></a>
                                <a href="http://twitter.com/pucmm/" class="text-white"><i class="fa fa-twitter fa-2x"></i></a>
                                <a href="http://www.youtube.com/pucmmtv/" class="text-white"><i class="fa fa-youtube-play fa-2x"></i></a>
                                <a href="http://www.instagram.com/pucmm" class="text-white"><i class="fa fa-instagram fa-2x"></i></a>
                                <a href="https://www.linkedin.com/edu/school?id=12020" class="text-white"><i class="fa fa-linkedin fa-2x"></i></a>
                            </div>
                        </div>
                    </div>
                    <div class="text-center mt-4">
                        <p class="m-0">© 2025 PUCMM</p>
                    </div>
                </div>
            </footer>
        `;
    }
}

// Actualizar el footer al cargar la página
window.onload = function() {
    updateFooter();
};