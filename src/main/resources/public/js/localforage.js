import localforage from 'localforage';

localforage.getItem('registro-1').then((registro) => {
    if (registro !== null) {
        console.log('Registro encontrado:', registro);
    } else {
        console.log('Registro no encontrado.');
    }
}).catch((error) => {
    console.error('Error al recuperar el registro:', error);
});

localforage.iterate((value, key) => {
    console.log('Key:', key, 'Value:', value);
}).catch((error) => {
    console.error('Error al iterar sobre los registros:', error);
});

localforage.iterate((value, key) => {
    fetch('http://tu-servidor-javalin.com/api/registros', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(value),
    })
        .then(response => {
            if (response.ok) {
                console.log('Registro enviado al servidor:', value);
            } else {
                console.error('Error al enviar el registro al servidor:', response.statusText);
            }
        })
        .catch(error => {
            console.error('Error al enviar el registro al servidor:', error);
        });
})
    .then(() => {
        console.log('Todos los registros enviados al servidor.');
    })
    .catch(error => {
        console.error('Error al obtener los registros:', error);
    });

localforage.removeItem(idAEliminar).then(() => {
    console.log('Registro eliminado correctamente.');
}).catch((error) => {
    console.error('Error al eliminar el registro:', error);
});






