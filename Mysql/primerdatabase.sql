select * from empleados;
select * from departamentos;
select nombre_depto from departamentos;
select nombre,sal_emp from empleados;
select comision_emp from empleados;
select*from empleados where cargo_emp = 'Secretaria';
select*from empleados where cargo_emp = 'Vendedor'order by nombre asc ;
select nombre,cargo_emp,sal_emp from empleados  order by sal_emp asc ;
select nombre_jefe_depto from departamentos where ciudad = 'CIUDAD REAL';
select nombre,cargo_emp from empleados;
select sal_emp, comision_emp from empleados where id_depto = 2000 order by comision_emp;
select nombre,sum(sal_emp + comision_emp +500) from empleados where id_depto = 3000 group by nombre order by nombre; 
select * from empleados where nombre like 'j%';
select nombre,sal_emp,comision_emp, sum(sal_emp+comision_emp)  from empleados where comision_emp > 1000 group by nombre,sal_emp,comision_emp;
select nombre,sal_emp,comision_emp, sum(sal_emp+comision_emp)  from empleados where comision_emp = 0 group by nombre,sal_emp,comision_emp;
select nombre from empleados where comision_emp> sal_emp;
select nombre from empleados where comision_emp <= (sal_emp*0.3);
select nombre from empleados where nombre not like'%ma%';
select nombre_jefe_depto,nombre_depto from departamentos where nombre_depto = 'investigacion' or nombre_depto = 'ventas' or nombre_depto = 'mantenimiento';
select nombre_jefe_depto,nombre_depto from departamentos where  not nombre_depto = 'investigacion' and not nombre_depto = 'ventas' and not nombre_depto = 'mantenimiento';
select max(sal_emp) from empleados ;
select nombre from empleados order by nombre desc limit 1;
select max(sal_emp),min(sal_emp),(max(sal_emp)-min(sal_emp)) from empleados;
select ciudad,avg(sal_emp) from departamentos,empleados  group by ciudad;
SELECT id_depto, AVG(sal_emp) as salario_promedio FROM empleados GROUP BY id_depto;/*25. Hallar los departamentos que tienen más de tres empleados. Mostrar el número de
empleados de esos departamentos.*/
SELECT id_depto, COUNT(*) AS id_emp FROM empleados GROUP BY id_depto HAVING COUNT(*) = 3;






