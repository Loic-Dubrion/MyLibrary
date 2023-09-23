package org.myLibrary.ui.frames;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame {

    private JButton viewBooksButton;
    private JButton searchBookButton;
    private JButton addBookButton;

    public MainWindow() {
        // Titre de la fenêtre
        setTitle("Ma Bibliothèque");

        // Taille de la fenêtre
        setSize(800, 800);

        // Positionnement de la fenêtre au centre
        setLocationRelativeTo(null);

        // Arrêt du programme lors de la fermeture de la fenêtre
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Layout Manager
        setLayout(new FlowLayout());

        // Initialisation des boutons
        viewBooksButton = new JButton("Voir mes livres");
        searchBookButton = new JButton("Rechercher un livre");
        addBookButton = new JButton("Ajouter un livre");

        // Layout Manager
        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        // Centrer les composants horizontalement et verticalement
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.fill = GridBagConstraints.NONE;
        constraints.gridx = 0;
        constraints.gridy = GridBagConstraints.RELATIVE;

        // Ajouter un espace entre les boutons
        constraints.insets = new Insets(30, 0, 30, 0);

        // Initialisation des boutons
        viewBooksButton = new JButton("Voir mes livres");
        searchBookButton = new JButton("Rechercher un livre");
        addBookButton = new JButton("Ajouter un livre");

        // Ajout des boutons au contenu de la fenêtre
        add(viewBooksButton, constraints);
        add(searchBookButton, constraints);
        add(addBookButton, constraints);

        // Ajout des ActionListener
        viewBooksButton.addActionListener(new ViewBooksAction());
        searchBookButton.addActionListener(new SearchBookAction());
        addBookButton.addActionListener(new AddBookAction());
    }

    // Classes ActionListener pour chaque bouton
    private static class ViewBooksAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Logique pour afficher les livres
        }
    }

    private static class SearchBookAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Logique pour rechercher un livre
        }
    }

    private static class AddBookAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Logique pour ajouter un livre
        }
    }

    // Méthode main pour lancer l'application
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainWindow mainWindow = new MainWindow();
            mainWindow.setVisible(true);
        });
    }
}
