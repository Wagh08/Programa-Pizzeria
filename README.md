# Programa-Pizzeria

## Errores y Modificaciones que corregí:

| Error | Corrección |
|-------|------------|
| Mayusculas/Minúsculas Incorrectas | Se escribieron los atributos y métodos correctamente en cuanto a mayúsculas/minúsculas. |
| Parametros faltantes | Se agregaron los parametros necesarios a métodos que en el UML se dejaron vacíos. |
| Tipo de preguntarPorOrden | Se hizo de tipo boolean el método de cocina que verifica si hay espacio para una orden más. |
| Orden no estaba asociada con cocina | Se agregó el atributo de tipo cocina a orden y a su constructor. |
| Orden no podía guardar las elecciones del cliente | Se le agregaron atributos para que guarde la información del pedido y los métodos para que el cliente haga la orden. |
| Cocina no puede acceder a la desc. de la orden | Se agregaron getter a orden. |
| No existe la dependencia cliente-cocina | Se agregó cocina como parámetro en métodos de cliente. |
| Funcionalidad califiacion irrelavante | Se eliminó el método de cliente. |
| No se puede agregar una orden a cocina | Se realizó un método para que si la orden se valida, cocine agregue la orden a sus pendientes. |
| Pizzas personalizadas o predeterminadas | Se configuraron metodos de overloading para realizar pizzas de esas formas. |
