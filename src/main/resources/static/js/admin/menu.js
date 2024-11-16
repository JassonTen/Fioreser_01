document.addEventListener('DOMContentLoaded', () => {
  const links = document.querySelectorAll('.nav-link');  // Selecciona todos los enlaces del menú
  const mainContent = document.getElementById('main-content');  // Contenedor donde se cargará el contenido

  links.forEach(link => {
      link.addEventListener('click', async (event) => {
          event.preventDefault();  // Evita que la página se recargue

          const pageUrl = link.getAttribute('href');  // Obtiene el valor de href

          if (pageUrl) {
              try {
                  const response = await fetch(pageUrl);  // Realiza una solicitud para obtener la página
                  if (!response.ok) throw new Error('Error en la carga del contenido');

                  const content = await response.text();  // Obtiene el contenido de la página
                  mainContent.innerHTML = content;  // Inserta el contenido en el contenedor principal
              } catch (error) {
                  console.error("Error al cargar la página:", error);
                  mainContent.innerHTML = "<p>Error al cargar el contenido.</p>";  // Muestra un mensaje de error
              }
          }
      });
  });
});


let toggle = document.querySelector(".toggle");
let navigation = document.querySelector(".navigation");
let main = document.querySelector(".main");

toggle.onclick = function () {
    navigation.classList.toggle("active");
    main.classList.toggle("active");
};

