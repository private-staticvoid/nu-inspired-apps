package Encapsulation;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class Library extends JFrame implements ActionListener {
    private JComboBox<books> comboBox;
    private JTextArea outputTextArea; // Text area to display book information
    private JLabel bookImageLabel; // Label to display book image

    public class books {
        private String name;
        private String author;
        private String pages;
        private String genre;
        private String rd;

        public books(String name, String author, String pages, String genre, String rd) {
            this.name = name;
            this.author = author;
            this.pages = pages;
            this.genre = genre;
            this.rd = rd;
        }

        public String getname() {
            return name;
        }

        public String getauthor() {
            return author;
        }

        public String getpages() {
            return pages;
        }

        public String getgenre() {
            return genre;
        }

        public String getrd() {
            return rd;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    private JFrame frame;

    Library() {

        frame = new JFrame("Nu Library");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(760, 540); // Adjusted size
        frame.getContentPane().setBackground(Color.BLACK);

        // Create a panel for the home page
        JPanel homePanel = new JPanel();
        homePanel.setLayout(new BoxLayout(homePanel, BoxLayout.Y_AXIS));
        homePanel.setBackground(new Color(59, 89, 182));
        // Load image from file
        ImageIcon imageIcon = new ImageIcon("C:\\Users\\Aki\\Downloads\\nulogo (1).png");
        Image image = imageIcon.getImage(); // transform it
        Image newimg = image.getScaledInstance(200, 200, Image.SCALE_SMOOTH); // scale it the smooth way
        imageIcon = new ImageIcon(newimg); // transform it back
        JLabel imageLabel = new JLabel(imageIcon);
        imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        homePanel.add(imageLabel);

        JLabel titleLabel = new JLabel("National University");
        titleLabel.setFont(new Font("Tahoma", Font.BOLD, 48)); // Changed font to Comic Sans MS
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        titleLabel.setForeground(new Color(255, 215, 0));
        homePanel.add(Box.createVerticalGlue());
        homePanel.add(titleLabel);
        homePanel.add(Box.createVerticalStrut(20));
        JLabel titleLabel1 = new JLabel("Library System");
        titleLabel1.setFont(new Font("Tahoma", Font.BOLD, 48)); // Changed font to Comic Sans MS
        titleLabel1.setAlignmentX(Component.CENTER_ALIGNMENT);
        titleLabel1.setForeground(new Color(255, 215, 0));
        homePanel.add(Box.createVerticalGlue());
        homePanel.add(titleLabel1);
        homePanel.add(Box.createVerticalStrut(20));

        // Create a start button
        JButton startButton = new JButton("Start");
        startButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        startButton.setFont(new Font("Tahoma", Font.BOLD, 18));
        startButton.setBackground(new Color(59, 134, 191));
        startButton.setForeground(new Color(255, 215, 0));
        startButton.setPreferredSize(new Dimension(400, 50)); // Increased button size
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showlbPanel(); // Show the game panel when start button is clicked
            }
        });
        homePanel.add(startButton);
        homePanel.add(Box.createVerticalStrut(100));

        // Add the home panel to the frame
        frame.add(homePanel);
        frame.setVisible(true);
    }

    // Method to show the game panel
    private void showlbPanel() {
        frame.getContentPane().removeAll(); // Remove all components from the frame
        frame.getContentPane().setBackground(Color.BLACK);

        // Create a panel for the elements
        JPanel lbPanel = new JPanel(new GridBagLayout());
        lbPanel.setBackground(new Color(59, 89, 182));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);

        // Create an output text area to display book information
        outputTextArea = new JTextArea(5, 30);
        outputTextArea.setEditable(false);
        outputTextArea.setBackground(new Color(240,248,255));
        outputTextArea.setForeground(new Color(70,130,180));
        outputTextArea.setFont(new Font("Tahoma", Font.BOLD, 14));
        JScrollPane scrollPane = new JScrollPane(outputTextArea);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        lbPanel.add(scrollPane, gbc);

        // Create a label to display book image
        bookImageLabel = new JLabel();
        bookImageLabel.setPreferredSize(new Dimension(150, 220));
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        lbPanel.add(bookImageLabel, gbc);

        // Create a button to select a book
        JButton bookButton = new JButton("Select A Book");
        bookButton.setFont(new Font("Tahoma", Font.BOLD, 18));
        bookButton.setBackground(new Color(59, 134, 191));
        bookButton.setForeground(new Color(255, 215, 0));
        bookButton.setPreferredSize(new Dimension(250, 50));
        bookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                books[] book = {
                		new books("Diary of the Wimpy Kid", "Jeff Kinney", "221", "Comedy, Young Adult", "April 1, 2007"),
                        new books("Everything, Everything", "Nicola Yoon", "310", "Novel, Young adult literature", "September 1, 2015"),
                        new books("Gone Girl", "Gillian Flynn", "432", "Novel, Thriller, Fiction, Mystery, Suspense", "May 24, 2012"),
                        new books("Gossip Girl", "Cecily von Ziegesar", "224", "Young adult literature", "April 1, 2002"),
                        new books("Harry Potter and the Goblet of Fire", "J.K. Rowling", "636", "Fantasy", "July 8, 2000"),
                        new books("Kapitan Sino", "Bob Ong", "166", "Novel, Fiction, Humor", "2009"),
                        new books("Little Women", "Louisa May Alcott", "759", "Coming of Age", "1868"),
                        new books("Moby-Dick", "Herman Melville", "378", "Adventure fiction, Epic", "October 18, 1851"),
                        new books("Pretty Little Liars", "Sara Shepard", "286", "Mystery, Young Adult, Romance, Coming of Age, Slice of Life", "October 3, 2006"),
                        new books("The Farm", "Joanne Ramos", "336", "Psychological Fiction, Domestic Fiction", "May 7, 2019"),
                        new books("The Lightning Thief", "Rick Riordan", "377", "Fantasy, Young Adult, Greek Mythology", "June 28, 2005"),
                        new books("The Perks of Being a Wallflower", "Stephen Chbosky", "256", "Novel, Young adult literature, Epistolary novel, Bildungsroman", "February 1, 1999"),
                        new books("The Seven Husbands of Evelyn Hugo", "Taylor Jenkins Reid", "400", "Novel, Romance, Historical Fiction", "June 13, 2017"),
                        new books("To All the Boys I've Loved Before", "Jenny Han", "421", "Young adult literature, Romance novel", "April 15, 2014"),
                        new books("To Kill A Mockingbird", "Harper Lee", "336", "Novel, Bildungsroman", "July 11, 1960")

                };

                books selectedBook = (books) JOptionPane.showInputDialog(null, "Select a Book", "Book Options", JOptionPane.QUESTION_MESSAGE, null, book, book[0]);
                if (selectedBook != null) {
                    // Display book information in the output text area
                    String info = "Title: " + selectedBook.getname() + "\n"
                            + "Author: " + selectedBook.getauthor() + "\n"
                            + "Pages: " + selectedBook.getpages() + "\n"
                            + "Genre: " + selectedBook.getgenre() + "\n"
                            + "Release Date: " + selectedBook.getrd();
                    outputTextArea.setText(info);

                    // Display corresponding image
                    switch (selectedBook.getname()) {
                    case "Diary of the Wimpy Kid":
                        setBookImage("Diary of the Wimpy Kid.png");
                        break;
                    case "Everything, Everything":
                        setBookImage("Everything, Everything.jpg");
                        break;
                    case "Gone Girl":
                        setBookImage("Gone Girl.jpg");
                        break;
                    case "Gossip Girl":
                        setBookImage("Gossip Girl.jpg");
                        break;
                    case "Harry Potter and the Goblet of Fire":
                        setBookImage("Harry Potter and the Goblet of Fire.png");
                        break;
                    case "Kapitan Sino":
                        setBookImage("Kapitan Sino.png");
                        break;
                    case "Little Woman":
                        setBookImage("Little Woman.png");
                        break;
                    case "Moby-Dick":
                        setBookImage("Moby-Dick.png");
                        break;
                    case "Pretty Little Liars":
                        setBookImage("Pretty Little Liars.png");
                        break;
                    case "The Lightning Thief":
                        setBookImage("The Lightning Thief.png");
                        break;
                    case "The Perks of Being a Wallflower":
                        setBookImage("The Perks of Being a Wallflower.jpg");
                        break;
                    case "The Seven Husbands of Evelyn Hugo":
                        setBookImage("The Seven Husbands of Evelyn Hugo.png");
                        break;
                    case "The Farm":
                        setBookImage("The Farm.png");
                        break;
                    case "To Kill A Mockingbird":
                        setBookImage("To Kill A Mockingbird.png");
                        break;
                    case "To All the Boys I've Loved Before":
                        setBookImage("To All the Boys I've Loved Before.jpg");
                        break;
                        default:
                            // Set a default image if no specific image is found
                            setBookImage("default.jpg");
                    }
                }
            }
        });
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        lbPanel.add(bookButton, gbc);

        // Create an exit button
        JButton exitButton = new JButton("Exit");
        exitButton.setPreferredSize(new Dimension(250, 50));
        exitButton.setFont(new Font("Tahoma", Font.BOLD, 18));
        exitButton.setBackground(new Color(59, 134, 191));
        exitButton.setForeground(new Color(255, 215, 0));
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // Exit the library when exit button is clicked
            }
        });
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        lbPanel.add(exitButton, gbc);

        // Add the panel to the frame
        frame.add(lbPanel);
        frame.revalidate();
        frame.repaint();

        // Play background music
        playBackgroundMusic();
    }

    // Method to set book image
    private void setBookImage(String imageName) {
        ImageIcon icon = new ImageIcon("C:\\Users\\Aki\\Downloads\\" + imageName);
        Image image = icon.getImage().getScaledInstance(150, 220, Image.SCALE_SMOOTH);
        bookImageLabel.setIcon(new ImageIcon(image));
    }

    private Clip musicClip;

    private void playBackgroundMusic() {
        try {
            String audioFilePath = "C:\\Users\\Aki\\Downloads\\shapebg2.wav"; // Specify the path to your audio file
            File audioFile = new File(audioFilePath);
            if (!audioFile.exists()) {
                System.err.println("Audio file not found: " + audioFilePath);
                return;
            }

            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(audioFile);
            musicClip = AudioSystem.getClip();
            musicClip.open(audioInputStream);
            musicClip.loop(Clip.LOOP_CONTINUOUSLY);
            musicClip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Library();
    }

    @Override
    // ActionPerformed method
    public void actionPerformed(ActionEvent e) {
        // Get selected book from the combo box
        books selectedBook = (books) comboBox.getSelectedItem();
        if (selectedBook != null) {
            // Display book information
            String info = "Title: " + selectedBook.getname() + "\n"
                    + "Author: " + selectedBook.getauthor() + "\n"
                    + "Pages: " + selectedBook.getpages() + "\n"
                    + "Genre: " + selectedBook.getgenre() + "\n"
                    + "Release Date: " + selectedBook.getrd();
            outputTextArea.setText(info);

            // Display corresponding image
            switch (selectedBook.getname()) {
                case "Diary of the Wimpy Kid":
                    setBookImage("diary_of_the_wimpy_kid.jpg");
                    break;
                case "Everything, Everything":
                    setBookImage("everything_everything.jpg");
                    break;
                // Add cases for other books here
                default:
                    // Set a default image if no specific image is found
                    setBookImage("default.jpg");
            }
        }
    }
}
