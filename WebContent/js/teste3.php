<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
<style>body {
        font-family:Tahoma, Geneva, sans-serif;
        font-size:12px;
}

.slide {
        width: 500px;
        border: 1px solid #36F;
        display: block;
        padding:5px
}

.slide .navegacao {
        border: 1px solid #000;
        padding: 3px;
        background-color:#BDD2FF;
        width:80px;
        font-weight:bold;
        text-align:center;
        float:left
}

.slide #anterior {
        margin-right:5px;       
}

.slide .bloco_navegacao {
        width:100%;
        display:block;
        height:27px;
}

.slide .navegacao:hover {
        background-color:#ECF1FF;
}

.slide .navegacao a:link {
        text-decoration:none;
        color:#333;
}

.slide .nav,.slide #nav  {
        display:block;  
        float:none;
        padding: 3px;
        margin-top:1px;
        float:left;
}

.slide .nav a {
        border: 1px solid #000;
        padding-top: 3px;
        padding-bottom: 3px;
        padding-left:5px;
        padding-right: 5px;
        background-color:#BDD2FF;
        margin-right:5px;
        text-decoration:none;
        color:#000;
}

.slide #nav a.activeSlide { 
        background: #ECF1FF;
}

.slide #conteudo {
        display:block;
}

.slide h1 {
        margin:0;
        font-family:Tahoma, Geneva, sans-serif;
}

.slide #conteudo .conteudo_img {
        float:left;
        margin-right:10px;
        border:1px solid #000;
}

.slide #conteudo .texto{
        padding:10px;
}dd</style>
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-2" />
        <title>Slides</title>
          <script src="jquery.min.js"language="javascript"></script> 
        
                <script src="jquery-latest.js"language="javascript"></script> 
        <script src="jquery.cycle.all.2.74.js" language="javascript"></script>
        
        <link href="estilo.css" type="text/css" rel="stylesheet" />     

                <script type="text/javascript">
                        $(document).ready(function() {
                                
                                $('#conteudo').cycle({
                                        timeout: 8000, //Tempo da transiçao
                                        speed:   400,  //Velocidade da transiçao
                                        fx:      'fade', //Tipo
                                        pager:   '#nav', //A div que vai aprensetar os números do slides
                                        prev:    '#anterior', //Link para voltar ao slide anterior
                                        next:    '#proxima' //Link para próximo slide
                                });
                        });
        </script>           
        
    </head>
    
    <body>
                
        <div class="slide">
                        <div class="bloco_navegacao">
                <div id="anterior" class="navegacao">
                    <a href="javascript:void(0)"><strong><<</strong></a>
                </div> 
                
                <div id="nav" class="nav">
                </div>
                
                <div id="proxima" class="navegacao">
                    <a href="javascript:void(0)"><strong>>></strong></a>
                </div> 
            </div>

            <div id="conteudo">

                <div>
                    <div class="conteudo_img">
                        <img src="imagens/img1.jpg" width="258" height="193"/>
                    </div>
                    
                    <h1>Title 1</h1>
        
                    <div class="texto">
                                                Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec pede justo, fringilla vel, aliquet nec, vulputate eget, arcu.
                    </div>
                </div>
                    
                <div>
                    <div class="conteudo_img">
                        <img src="imagens/img2.jpg" width="258" height="193"/>
                    </div>
                    
                    <h1>Title 2</h1>
        
                    <div class="texto">
                                                Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec pede justo, fringilla vel, aliquet nec, vulputate eget, arcu.
                    </div>
                </div>
                    
                <div>
                    <div class="conteudo_img">
                        <img src="imagens/img3.jpg" width="258" height="193">
                    </div>
                    
                    <h1>Title 3</h1>
        
                    <div class="texto">
                                                Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec pede justo, fringilla vel, aliquet nec, vulputate eget, arcu.
                    </div>
                </div>

            </div>
                </div>     
    
    </body>
</html>