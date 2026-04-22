
##  Requisitos

Herramienta  y Versión mínima 
 Java         17+           
 Maven        3.8+          



## ejecutar
 Compilar y ejecutar
 
./mvnw spring-boot:run




localhost: **http://localhost:8081**



##  Endpoints disponibles


GET  /recetas                        
Devuelve todas las recetas   


 GET /recetas/{id}
 Devuelve una receta por ID  

 GET /recetas/categoria/{categoria} 
 Filtra recetas por categoría 


## Categorías disponibles

- Plato Fuerte
- Sopa
- Desayuno
- Postre
- Bebida

## Consumir desde React

```js
// Obtener todas las recetas
const res = await fetch('http://localhost:8081/recetas');
const recetas = await res.json();

// Filtrar por categoría
const res = await fetch('http://localhost:8081/recetas/categoria/Sopa');
const sopas = await res.json();
```

>  CORS está habilitado para todos los orígenes (`@CrossOrigin("*")`).
