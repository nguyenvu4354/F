<%-- 
    Document   : Login
    Created on : 14 Oct, 2023, 12:49:33 AM
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Login</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper@10/swiper-bundle.min.css" />
        <link rel="stylesheet" href="./style.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css" integrity="sha512-z3gLpd7yknf1YoNbCzqRKc4qyor8gaKU1qmn+CShxbuBusANI9QpRohGBreCFkKxLhei6S9CQXFEbbKuqLg0DA==" crossorigin="anonymous" referrerpolicy="no-referrer"
              />
        <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
    </head>

    <body>
        <section id="header" class="header-login">
            <div class="container">
                <div class="row align-items-center h-78">
                    <div class="col-md-1">
                        <div class="header-logo">
                            <a href="#"><img src="./images/headerLogo.png" alt=""></a>
                        </div>
                    </div>
                </div>
            </div>
        </section>


        <section class="signup-body">
            <form action="login" method="post" class="mx-auto">
                <div class="bg-white p-5 form-login">
                    <h1 class="text-center fw-bold">Login</h1>
                    <div class="">
                        <div class="border-bottom">
                            <span class="fs-5 fw-bold text-black-weak">Username</span>
                            <div class="d-flex align-items-center fs-4 mt-3">
                                <i class='bx bx-user'></i>
                                <input type="text" name="username" value="" placeholder="Username" class="w-100 py-4 outline-0 border-0 ms-3" />
                            </div>
                        </div>
                        <div class="border-bottom mt-5">
                            <span class="fs-5 fw-bold text-black-weak">password</span>
                            <div class="d-flex align-items-center fs-4 mt-3">
                                <i class='bx bx-lock'></i>
                                <input type="password" value="" name="password" placeholder="Password" class="w-100 py-4 outline-0 border-0 ms-3" />
                            </div>
                        </div>
                    </div>
                    <div class="text-center mt-3 fs-5">
                        Do you want to create an account?
                        <a href="signup" class="text-black-weak text-info">Sign up</a>
                    </div>
                     <button type="submit" class="d-flex align-items-center justify-content-center mt-5 fw-bold py-2 fs-4 px-5 btn bg-danger text-white  mx-auto">Submit</button>
                </div>
            </form>
            <h3>${mess!=null?mess:""}</h3>
        </section>
    </body>
</html>

