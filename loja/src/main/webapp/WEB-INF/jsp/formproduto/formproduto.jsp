<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags/" prefix="tag"%>
<%@ taglib tagdir="/WEB-INF/tags/" prefix="tag"%>
<html lang="pt-br">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>E-Commerce - Form Produto</title>
        <link rel="icon" type="image/x-icon" href="assets/img/favicon.ico" />
        <!-- Font Awesome icons (free version)-->
        <script src="https://use.fontawesome.com/releases/v5.15.1/js/all.js" crossorigin="anonymous"></script>
        <!-- Google fonts-->
        <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css" />
        <link href="https://fonts.googleapis.com/css?family=Droid+Serif:400,700,400italic,700italic" rel="stylesheet" type="text/css" />
        <link href="https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700" rel="stylesheet" type="text/css" />
        <link href="css/glyphicon.css" media="all" rel="stylesheet" type="text/css"/>
        <link href="css/fileinput.min.css" media="all" rel="stylesheet" type="text/css"/>
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="css/styles.css" rel="stylesheet" />
    </head>
    <body id="page-top">
        <!-- Navigation-->
       <tag:menuSuperior>
       </tag:menuSuperior>
        </nav>
        <!-- Masthead-->
        <header class="masthead" id="login">
            <div class="container">
               
            </div>
        </header>
        <!-- formproduto-->
        <section class="page-section" id="formproduto">
            <div class="container">
                <div class="text-center">
                    <h2 class="section-heading text-uppercase">Novo Produto/Editar Produto</h2>
                    
                </div>
                
                
                 <c:if test="${not empty errors}">
                    
                     <div class="alert alert-danger" role="alert">
                        <c:forEach var="error" items="${errors}">
                           ${error.message}<br/>
                         	
                        </c:forEach>
                    
                    
                    </div>
                    
                    </c:if>
                
                
                <form method="post" action="<c:url value="/formproduto/salvaProduto"/>"enctype="multipart/form-data">
                    <div class="row justify-content-md-center mb-5 text-center">
                        <div class="col-md-12 align-self-center text-center">
                            <div class="form-group input-login mx-auto">
                                <input id="input-id" name="produto.imagem.file"  type="file" class="file" data-preview-file-type="text">
                                 <p class="help-block text-danger"></p>
                             </div>
                            <div class="form-group input-login mx-auto">
                                <input class="form-control" id="email" type="text" name="produto.nomeProduto"value="${produto.getNomeProduto()}" placeholder="Nome *" required="required" minlength="3" maxlength="50"  data-validation-required-message="O nome do produto não pode estar vazio" />
                                <p class="help-block text-danger"></p>
                            </div>
                            <div class="form-group input-login mx-auto">
                                <input class="form-control money" id="valor" name="produto.precoProduto"  value="${produto.getPrecoProduto()} type="tel" placeholder="Valor em R$*" required="required"   data-validation-required-message=" O valor do Produto nao pode ser inferior a 0" />                            
                                <p class="help-block text-danger"></p>
                            </div>
                            <div class="form-group input-login mx-auto">
                               <textarea class="form-control"  name="produto.descProduto" placeholder="Descreva o Produto">${produto.getDescProduto()}</textarea>
                          
                                <p class="help-block text-danger"></p>
                            </div>
                            <div class="form-group">
                                <select  name="produto.categoriaProduto.id" class="form-control input-login mx-auto" id="email" required="required"
                                  data-validation-required-message="Please enter your email address.">
                                  <c:forEach var="categorias" items="${categorias}">
                                  
                                  <option value="${categorias.id}">${categorias.nomeCategoria}</option>
                                  
                                  </c:forEach>
                                  
                                  
                                 
                                </select>
                                <p class="help-block text-danger"></p>
                            </div>
                            <div class="form-group input-login mx-auto">
                                <input class="form-control date-br" id="valor" name="produto.dataValidadeEm" value="${produto.getDataValidade()}" type="date" placeholder="Data Validade *" required="required" data-validation-required-message="Digite a data de Validade do Produto" />
                                <p class="help-block text-danger"></p>
                            </div>
                           
                            <button class="btn btn-primary btn-xl text-uppercase js-scroll-trigger" >Salvar</button>
                        </div> 
                    </div>
                </form>
            </div>
        </section>
    
        <!-- Footer-->
        <footer class="footer py-4">
            <div class="container">
                <div class="row align-items-center">
                    <div class="col-lg-4 text-lg-left">Copyright Â© SenaiCommerce 2021</div>
                    <div class="col-lg-4 my-3 my-lg-0">
                        <a class="btn btn-dark btn-social mx-2" href="#!"><i class="fab fa-twitter"></i></a>
                        <a class="btn btn-dark btn-social mx-2" href="#!"><i class="fab fa-facebook-f"></i></a>
                        <a class="btn btn-dark btn-social mx-2" href="#!"><i class="fab fa-linkedin-in"></i></a>
                    </div>
                    <div class="col-lg-4 text-lg-right">
                        <a class="mr-3" href="#!">Privacy Policy</a>
                        <a href="#!">Terms of Use</a>
                    </div>
                </div>
            </div>
        </footer>
        <!-- Bootstrap core JS-->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Third party plugin JS-->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.4.1/jquery.easing.min.js"></script>
        <!-- Contact form JS-->
        <script src="assets/mail/jqBootstrapValidation.js"></script>
        <script src="assets/mail/contact_me.js"></script>
        <!-- Core theme JS-->
        <script src="js/scripts.js"></script>
        
        <script src="js/jquery.mask.min.js"></script>
        <script src="js/fileinput/fileinput.min.js" type="text/javascript"></script>
        <script src="js/add-mask.js"></script>
        <script>

        </script>
    </body>
</html>
