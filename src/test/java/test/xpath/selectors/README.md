## / Beginn eines absoluten Path: /html/body/div[2]

### // relativer Pfad z.B. //button[@data-testid='royal_login_button']

### @ Attribut

### alternativ: //*[@data-testid='royal_login_button']

### ..   Parent selektieren      (hier CSS schlecht und Xpath besser)             z.B: //div[@class='article-layout__content-container']/..

### contains text methode auch nur bei xpath und nicht bei CSS verfügbar

### String xpath ="//div[@class='product-grid home-page-product-grid']//img/..";

### String xpath ="//*[contains(text(), 'Jetzt bestellen')]";