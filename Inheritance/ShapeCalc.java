package Inheritance;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
 
// Shape class
abstract class Shape {
    abstract double calculateArea();
    abstract double calculatePerimeter();
    abstract JPanel getInputPanel();
}
 
// Rectangle subclass
class Rectangle extends Shape {
    private double length;
    private double width;
 
    // Constructor
    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }
 
    // Overridden methods
    @Override
    double calculateArea() {
        return length * width;
    }
 
    @Override
    double calculatePerimeter() {
        return 2 * (length + width);
    }
 
    @Override
    JPanel getInputPanel() {
        JPanel panel = new JPanel(new GridLayout(2, 2));
        panel.add(new JLabel("Length:"));
        JTextField lengthField = new JTextField();
        panel.add(lengthField);
        panel.add(new JLabel("Width:"));
        JTextField widthField = new JTextField();
        panel.add(widthField);
 
        int result = JOptionPane.showConfirmDialog(null, panel, "Enter Rectangle Dimensions", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            length = Double.parseDouble(lengthField.getText());
            width = Double.parseDouble(widthField.getText());
        }
        return panel;
    }
}
 
// Circle subclass
class Circle extends Shape {
    private double radius;
 
    // Constructor
    public Circle(double radius) {
        this.radius = radius;
    }
 
    // Overridden methods
    @Override
    double calculateArea() {
        return Math.PI * radius * radius;
    }
 
    @Override
    double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }
 
    @Override
    JPanel getInputPanel() {
        JPanel panel = new JPanel(new GridLayout(1, 2));
        panel.add(new JLabel("Radius:"));
        JTextField radiusField = new JTextField();
        panel.add(radiusField);
 
        int result = JOptionPane.showConfirmDialog(null, panel, "Enter Circle Radius", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            radius = Double.parseDouble(radiusField.getText());
        }
        return panel;
    }
}
 
// Triangle subclass
class Triangle extends Shape {
    private double base;
    private double height;
    private double side1;
    private double side2;
    private double side3;
 
    // Constructor
    public Triangle(double base, double height, double side1, double side2, double side3) {
        this.base = base;
        this.height = height;
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }
 
    // Overridden methods
    @Override
    double calculateArea() {
        return 0.5 * base * height;
    }
 
    @Override
    double calculatePerimeter() {
        return side1 + side2 + side3;
    }
 
    @Override
    JPanel getInputPanel() {
        JPanel panel = new JPanel(new GridLayout(5, 2));
        panel.add(new JLabel("Base:"));
        JTextField baseField = new JTextField();
        panel.add(baseField);
        panel.add(new JLabel("Height:"));
        JTextField heightField = new JTextField();
        panel.add(heightField);
        panel.add(new JLabel("Side 1:"));
        JTextField side1Field = new JTextField();
        panel.add(side1Field);
        panel.add(new JLabel("Side 2:"));
        JTextField side2Field = new JTextField();
        panel.add(side2Field);
        panel.add(new JLabel("Side 3:"));
        JTextField side3Field = new JTextField();
        panel.add(side3Field);
 
        int result = JOptionPane.showConfirmDialog(null, panel, "Enter Triangle Dimensions", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            base = Double.parseDouble(baseField.getText());
            height = Double.parseDouble(heightField.getText());
            side1 = Double.parseDouble(side1Field.getText());
            side2 = Double.parseDouble(side2Field.getText());
            side3 = Double.parseDouble(side3Field.getText());
        }
        return panel;
    }
}
 
// Square subclass
class Square extends Shape {
    private double side;
 
    // Constructor
    public Square(double side) {
        this.side = side;
    }
 
    // Overridden methods
    @Override
    double calculateArea() {
        return side * side;
    }
 
    @Override
    double calculatePerimeter() {
        return 4 * side;
    }
 
    @Override
    JPanel getInputPanel() {
        JPanel panel = new JPanel(new GridLayout(1, 2));
        panel.add(new JLabel("Side:"));
        JTextField sideField = new JTextField();
        panel.add(sideField);
 
        int result = JOptionPane.showConfirmDialog(null, panel, "Enter Square Side", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            side = Double.parseDouble(sideField.getText());
        }
        return panel;
    }
}
 
// Trapezoid subclass
class Trapezoid extends Shape {
    private double base1;
    private double base2;
    private double height;
    private double side1;
    private double side2;
 
    // Constructor
    public Trapezoid(double base1, double base2, double height, double side1, double side2) {
        this.base1 = base1;
        this.base2 = base2;
        this.height = height;
        this.side1 = side1;
        this.side2 = side2;
    }
 
    // Overridden methods
    @Override
    double calculateArea() {
        return ((base1 + base2) / 2) * height;
    }
 
    @Override
    double calculatePerimeter() {
        return base1 + base2 + side1 + side2;
    }
 
    @Override
    JPanel getInputPanel() {
        JPanel panel = new JPanel(new GridLayout(5, 2));
        panel.add(new JLabel("Base 1:"));
        JTextField base1Field = new JTextField();
        panel.add(base1Field);
        panel.add(new JLabel("Base 2:"));
        JTextField base2Field = new JTextField();
        panel.add(base2Field);
        panel.add(new JLabel("Height:"));
        JTextField heightField = new JTextField();
        panel.add(heightField);
        panel.add(new JLabel("Side 1:"));
        JTextField side1Field = new JTextField();
        panel.add(side1Field);
        panel.add(new JLabel("Side 2:"));
        JTextField side2Field = new JTextField();
        panel.add(side2Field);
 
        int result = JOptionPane.showConfirmDialog(null, panel, "Enter Trapezoid Dimensions", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            base1 = Double.parseDouble(base1Field.getText());
            base2 = Double.parseDouble(base2Field.getText());
            height = Double.parseDouble(heightField.getText());
            side1 = Double.parseDouble(side1Field.getText());
            side2 = Double.parseDouble(side2Field.getText());
        }
        return panel;
    }
}
 
// Frame class
class Frame extends JFrame implements ActionListener {
    private JFrame frame;
    private JButton circleButton;
    private JButton rectangleButton;
    private JButton triangleButton;
    private JButton squareButton;
    private JButton trapezoidButton;
    private JButton clearButton;
    private JTextArea outputTextArea;
 
    Frame() {
        super("Shape Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setSize(760, 450); // Adjusted size
        getContentPane().setBackground(Color.BLACK);
 
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
        titleLabel.setFont(new Font("Tahoma", Font.BOLD, 42)); // Changed font to Comic Sans MS
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        titleLabel.setForeground(new Color(255, 215, 0));
        homePanel.add(Box.createVerticalGlue());
        homePanel.add(titleLabel);
        homePanel.add(Box.createVerticalStrut(20));
        JLabel titleLabel1 = new JLabel("Shape Calculator");
        titleLabel1.setFont(new Font("Tahoma", Font.BOLD, 42)); // Changed font to Comic Sans MS
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
        add(homePanel);
        setLocationRelativeTo(null); // Center the frame
        setVisible(true);
    }
 
    private void showlbPanel() {
        getContentPane().removeAll(); // Remove the current panel
     
        
        JPanel shapePanel = new JPanel();
        shapePanel.setBackground(new Color(59, 89, 182));
 
        circleButton = new JButton("Circle");
        rectangleButton = new JButton("Rectangle");
        triangleButton = new JButton("Triangle");
        squareButton = new JButton("Square");
        trapezoidButton = new JButton("Trapezoid");
        clearButton = new JButton("Clear");
 
        Dimension buttonSize = new Dimension(250, 50);
        circleButton.setPreferredSize(buttonSize);
        rectangleButton.setPreferredSize(buttonSize);
        triangleButton.setPreferredSize(buttonSize);
        squareButton.setPreferredSize(buttonSize);
        trapezoidButton.setPreferredSize(buttonSize);
        clearButton.setPreferredSize(buttonSize);
 
        circleButton.setFont(new Font("Tahoma", Font.BOLD, 18));
        rectangleButton.setFont(new Font("Tahoma", Font.BOLD, 18));
        triangleButton.setFont(new Font("Tahoma", Font.BOLD, 18));
        squareButton.setFont(new Font("Tahoma", Font.BOLD, 18));
        trapezoidButton.setFont(new Font("Tahoma", Font.BOLD, 18));
        clearButton.setFont(new Font("Tahoma", Font.BOLD, 18));
 
        circleButton.setBackground(new Color(59, 134, 191));
        rectangleButton.setBackground(new Color(59, 134, 191));
        triangleButton.setBackground(new Color(59, 134, 191));
        squareButton.setBackground(new Color(59, 134, 191));
        trapezoidButton.setBackground(new Color(59, 134, 191));
        clearButton.setBackground(new Color(59, 134, 191));
 
        circleButton.setForeground(new Color(255, 215, 0));
        rectangleButton.setForeground(new Color(255, 215, 0));
        triangleButton.setForeground(new Color(255, 215, 0));
        squareButton.setForeground(new Color(255, 215, 0));
        trapezoidButton.setForeground(new Color(255, 215, 0));
        clearButton.setForeground(new Color(255, 215, 0));
 
        circleButton.addActionListener(this);
        rectangleButton.addActionListener(this);
        triangleButton.addActionListener(this);
        squareButton.addActionListener(this);
        trapezoidButton.addActionListener(this);
        clearButton.addActionListener(this);
 
        shapePanel.add(circleButton);
        shapePanel.add(rectangleButton);
        shapePanel.add(triangleButton);
        shapePanel.add(squareButton);
        shapePanel.add(trapezoidButton);
        JPanel lbPanel = new JPanel(new GridBagLayout());
        lbPanel.setBackground(new Color(59, 89, 182));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);
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
        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.setBackground(new Color(59, 89, 182));
        buttonPanel.add(clearButton);
        buttonPanel.add(lbPanel);
        outputTextArea = new JTextArea(5, 30);
        outputTextArea.setEditable(false);
        outputTextArea.setBackground(new Color(240, 248, 255));
        outputTextArea.setForeground(new Color(70, 130, 180));
        outputTextArea.setFont(new Font("Tahoma", Font.BOLD, 14));
        JScrollPane scrollPane = new JScrollPane(outputTextArea);
 
        add(scrollPane, BorderLayout.NORTH);
        add(shapePanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
        
    
        playBackgroundMusic();
        setLocationRelativeTo(null); // Center the frame
        setVisible(true);
    }
 
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == clearButton) {
            // Clear the text area
            outputTextArea.setText("");
        } else if (e.getSource() == circleButton) {
            // Handle circle button click
            Circle circle = new Circle(0);
            JPanel inputPanel = circle.getInputPanel();
            double area = circle.calculateArea();
            double perimeter = circle.calculatePerimeter();
            outputTextArea.append("Circle Area: " + area + "\n" +"Perimeter: " + perimeter + "\n\n");
        } else if (e.getSource() == rectangleButton) {
            // Handle rectangle button click
            Rectangle rectangle = new Rectangle(0, 0);
            JPanel inputPanel = rectangle.getInputPanel();
            double area = rectangle.calculateArea();
            double perimeter = rectangle.calculatePerimeter();
            outputTextArea.append("Rectangle Area: " + area +"\n" + "Perimeter: " + perimeter + "\n\n");
        } else if (e.getSource() == triangleButton) {
            // Handle triangle button click
            Triangle triangle = new Triangle(0, 0, 0, 0, 0);
            JPanel inputPanel = triangle.getInputPanel();
            double area = triangle.calculateArea();
            double perimeter = triangle.calculatePerimeter();
            outputTextArea.append("Triangle Area: " + area + "\n" +"Perimeter: " + perimeter + "\n\n");
        } else if (e.getSource() == squareButton) {
            // Handle square button click
            Square square = new Square(0);
            JPanel inputPanel = square.getInputPanel();
            double area = square.calculateArea();
            double perimeter = square.calculatePerimeter();
            outputTextArea.append("Square Area: " + area + "\n" + "Perimeter: " + perimeter + "\n\n");
        } else if (e.getSource() == trapezoidButton) {
            // Handle trapezoid button click
            Trapezoid trapezoid = new Trapezoid(0, 0, 0, 0, 0);
            JPanel inputPanel = trapezoid.getInputPanel();
            double area = trapezoid.calculateArea();
            double perimeter = trapezoid.calculatePerimeter();
            outputTextArea.append("Trapezoid Area: " + area +"\n" + "Perimeter: " + perimeter + "\n\n");
        }
    }
    private Clip musicClip;
 
    private void playBackgroundMusic() {
        try {
            String audioFilePath = "C:\\Users\\Aki\\Downloads\\library.wav"; // Specify the path to your audio file
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
}
 
// Main class
public class ShapeCalc {
    public static void main(String[] args) {
        new Frame();
    }
}