module br.edu.femass.bibliotecafemass {
    requires javafx.controls;
    requires javafx.fxml;


    opens br.edu.femass.bibliotecafemass to javafx.fxml;
    exports br.edu.femass.bibliotecafemass;
    exports br.edu.femass.bibliotecafemass.GUI;
    opens br.edu.femass.bibliotecafemass.GUI to javafx.fxml;
}