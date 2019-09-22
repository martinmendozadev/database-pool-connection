function validar() {

    // Array con todos los elementos del formulario
    camposTexto = form1.elements;
    
    for (x=0; x < camposTexto.length; x++) {
    
        //validar que los campos obligatorios se hayan llenado, con los demas campos, no hacer nada
        if(camposTexto[x].type=="text" && ( camposTexto[x].id=="novalid" ||  camposTexto[x].id=="Num. Seguro" ||  camposTexto[x].id=="Lugar de Nacimiento"   )){}//no hacer nada en este caso
            
        else if ( camposTexto[x].value == "" && ( camposTexto[x].type == "text") ) {
            alert("El campo " + camposTexto[x].id + " es obligatorio!");
            form1.elements[x].focus();
            return false;
        }

        if ( camposTexto[x].type =="text"  &&  camposTexto[x].id=="Edad/Mascota"){
            var checanum =/(^([0-9]){1,10}|^)$/
            if (!checanum.test (camposTexto[x].value)) {
                alert("El contenido del campo " + camposTexto[x].id +  " debe ser numerico entero!");
                form1.elements[x].value="";
                form1.elements[x].focus();
                return false;
            }
        }

        if ( camposTexto[x].type =="text"  &&  camposTexto[x].id=="Telefono"){
            var checanum =/(^([0-9]){1,10}|^)$/
            if (!checanum.test (camposTexto[x].value)) {
                alert("El contenido del campo " + camposTexto[x].id +  " sin gión o espacios\n y menor a 10 digitos");
                form1.elements[x].value="";
                form1.elements[x].focus();
                return false;
            }
        }
    
        if ( camposTexto[x].type =="text"  &&  camposTexto[x].id=="Peso"){
            var checanum = /(^([0-9,.]){1,20}|^)$/
            if (!checanum.test (camposTexto[x].value)) {
                alert("El contenido del campo " + camposTexto[x].id +  " debe ser numerico !");
                form1.elements[x].value="";
                form1.elements[x].focus();
                return false;
            }

            var campo_importe=camposTexto[x].value;
            var k=0;

            for (i=0; i < campo_importe.length; i++) {
                if (campo_importe.charAt(i)=='.'){
                    k++;
                }
            }

            if (k > 1) {
                alert("El contenido del campoo "+ camposTexto[x].id + " es invalido !");
                form1.elements[x].value="";
                form1.elements[x].focus();
                return false;
            }		
    
            k=0;
            for (i=0; i < campo_importe.length; i++) {
                if (campo_importe.charAt(i)==','){
                    k++;
                }
            }

            if (k > 0) {
                alert("El contenido del campo "+ camposTexto[x].id + " es invalido !");
                form1.elements[x].value="";
                form1.elements[x].focus();
                return false;
            }		    
        }
    
        if( camposTexto[x].class="select" && camposTexto[x].selectedIndex== 0 ){    
            alert("El campo " + camposTexto[x].id + " es obligatorio !");
            form1.elements[x].focus();
            return false;
        }
    
        if( camposTexto[x].type=="text" && camposTexto[x].id=="Fecha/Ingreso"){
            if (!checkDate(form1.elements[x].value)){
                //form1.elements[x].value="";
                form1.elements[x].focus();
                form1.elements[x].select();
                return false;
            }
        }

        if( camposTexto[x].type=="text" && camposTexto[x].id=="Ultimo/chequeo"){
            if (!checkDate(form1.elements[x].value)){
                //form1.elements[x].value="";
                form1.elements[x].focus();
                form1.elements[x].select();
                return false;
            }
        }
    }
}