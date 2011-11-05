$(function(){
	$(".abas").hide();
    $(".abas:first").show();//Fazemos com que a primeira class com o nome abas que demos fica visivel
 
    $("#nav_abas a").click(function(){ //Falamos que quando clicar no id nos mande para div que correspondende
        $(".abas").hide(); //faz somir as div que nao foram clicadas
 
        var div = $(this).attr('href'); // variavel para pegar o atributo href para saber em qual id o usuario clicou
 
        $(div).fadeIn(""); // faz a div correspondente clicada ficar visivel
            $("#nav_abas a").removeClass("current"); // remove a class no link clicado para que nao fica marcado
		
			
           $(this).addClass("current"); // adiciona a classe no link clicado para que o usuario saiba em qual link ele esta
 
        return false;
    })
});