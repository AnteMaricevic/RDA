import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class outside {

    private JFrame frame;
    private CardLayout cardLayout;
    private JPanel contentPanel;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    outside window = new outside();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public outside() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 530, 344);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        cardLayout = new CardLayout();
        contentPanel = new JPanel(cardLayout);

        // Initial panel with text and two buttons
        JPanel initialPanel = createInitialPanel();
        contentPanel.add(initialPanel, "InitialPanel");

        // Rain option panel
        JPanel rainPanel = createRainPanel();
        contentPanel.add(rainPanel, "RainPanel");

        // Sunny weather option panel
        JPanel sunnyPanel = createSunnyPanel();
        contentPanel.add(sunnyPanel, "SunnyPanel");

        // Final panel with detailed text and Next button
        JPanel finalPanel = createFinalPanel();
        contentPanel.add(finalPanel, "FinalPanel");

        // Add content panel to frame
        frame.getContentPane().add(contentPanel, BorderLayout.CENTER);
    }

    private JPanel createInitialPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        JTextArea textArea = new JTextArea();
        textArea.setWrapStyleWord(true);
        textArea.setLineWrap(true);
        textArea.setEditable(false);
        textArea.setText("You went outside and got into your car. It’s a rainy day, so you chose to put on a long-sleeved turtleneck, some thick pants and a coat. " +
                "After you put on your rain boots, you also picked up your beat-up umbrella for some extra rain protection. The extreme winds and heavy rain are at fault for the state of the poor thing. " +
                "You head out, pleasantly surprised that the rain is not heavy at all, but merely trickling as the sky has barely any rain clouds above your head. " +
                "There is even still some sun piercing through the clouds, warming your skin. You briefly think about whether you prefer rainy weather or clear skies…\n\nWhat do you prefer?");
        panel.add(new JScrollPane(textArea), BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        JButton rainButton = new JButton("Rain");
        JButton sunnyButton = new JButton("Sunny weather");

        rainButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(contentPanel, "RainPanel");
            }
        });

        sunnyButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(contentPanel, "SunnyPanel");
            }
        });

        buttonPanel.add(rainButton);
        buttonPanel.add(sunnyButton);

        panel.add(buttonPanel, BorderLayout.SOUTH);
        return panel;
    }

    private JPanel createRainPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        JTextArea textArea = new JTextArea();
        textArea.setWrapStyleWord(true);
        textArea.setLineWrap(true);
        textArea.setEditable(false);
        textArea.setText("Rainy days are the best. There are not many people around and the air always feels fresher. " +
                "Basking in the sound of rain droplets hitting your umbrella always calms you, and makes you enjoy walking through the streets at a leisurely pace. " +
                "That is exactly what you do now, that the weather is right.\n\n+ 1 sanity\n\nThe store is thankfully open in these early hours of the morning and there is barely anybody inside doing shopping alongside you. " +
                "Looks like you won’t have to wait forever in the line, and the cashiers will probably not be as grumpy as they tend to be after their third massive wave of rude people shoving foods and money into their faces. " +
                "You realize they have restocked recently, so even your favorite snacks and ingredients are available. What are you going to buy?");
        panel.add(new JScrollPane(textArea), BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        JButton instantFoodButton = new JButton("Instant food");
        JButton energyDrinksButton = new JButton("Energy drinks and coffee");
        JButton properMealButton = new JButton("Ingredients for a proper meal");
        JButton cannedFoodButton = new JButton("Canned food");

        ActionListener buttonListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(contentPanel, "FinalPanel");
            }
        };

        instantFoodButton.addActionListener(buttonListener);
        energyDrinksButton.addActionListener(buttonListener);
        properMealButton.addActionListener(buttonListener);
        cannedFoodButton.addActionListener(buttonListener);

        buttonPanel.add(instantFoodButton);
        buttonPanel.add(energyDrinksButton);
        buttonPanel.add(properMealButton);
        buttonPanel.add(cannedFoodButton);

        panel.add(buttonPanel, BorderLayout.SOUTH);
        return panel;
    }

    private JPanel createSunnyPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        JTextArea textArea = new JTextArea();
        textArea.setWrapStyleWord(true);
        textArea.setLineWrap(true);
        textArea.setEditable(false);
        textArea.setText("Sunny weather is the best. The warmth of the sun makes your muscles feel relaxed and brings out a cheery atmosphere in the crowds. " +
                "While heat can be a nuisance when extreme enough, right now the warmth is just right. If only it didn’t rain so you could enjoy it more. " +
                "Since you dislike the rain, you hurry to go to the store.\n\n+ 1 heat resistance\n\nThe store is thankfully open in these early hours of the morning and there is barely anybody inside doing shopping alongside you. " +
                "Looks like you won’t have to wait forever in the line, and the cashiers will probably not be as grumpy as they tend to be after their third massive wave of rude people shoving foods and money into their faces. " +
                "You realize they have restocked recently, so even your favorite snacks and ingredients are available. What are you going to buy?");
        panel.add(new JScrollPane(textArea), BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        JButton instantFoodButton = new JButton("Instant food");
        JButton energyDrinksButton = new JButton("Energy drinks and coffee");
        JButton properMealButton = new JButton("Ingredients for a proper meal");
        JButton cannedFoodButton = new JButton("Canned food");

        ActionListener buttonListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(contentPanel, "FinalPanel");
            }
        };

        instantFoodButton.addActionListener(buttonListener);
        energyDrinksButton.addActionListener(buttonListener);
        properMealButton.addActionListener(buttonListener);
        cannedFoodButton.addActionListener(buttonListener);

        buttonPanel.add(instantFoodButton);
        buttonPanel.add(energyDrinksButton);
        buttonPanel.add(properMealButton);
        buttonPanel.add(cannedFoodButton);

        panel.add(buttonPanel, BorderLayout.SOUTH);
        return panel;
    }

    private JPanel createFinalPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        JTextArea textArea = new JTextArea();
        textArea.setWrapStyleWord(true);
        textArea.setLineWrap(true);
        textArea.setEditable(false);
        textArea.setText("As you were checking out at the cashier, you noticed the lady behind you in the line staring at you. " +
                "You tried to ignore her for a while, but as she just kept staring, you finally gave in the urge to have a look. You wish you hadn’t. " +
                "Her face is too familiar and gives you a feeling of dread. You are sure you have seen her before, but you can’t remember where no matter how much you try to recall. " +
                "As you focus on the features of her face, something starts to feel terribly wrong. It’s her eyes… no, her cheek? Why have you found her familiar again? " +
                "This looks nothing like the person you imagined. As you look closer, this isn’t even a woman. It’s a man, and his eyes are not his eyes, but are instead gaping mouths, " +
                "their teeth full of holes – the home of thousands of writhing worms. His cheeks… his cheeks have faces of their own. The faces that briefly ran across your mind before. " +
                "The faces of…\n\n“Sir, if you do not wish to get thrown out, please refrain from staring at the lady like that.” The cashier says, which snaps you out of your temporary daze. " +
                "When you glance back at the woman behind you, she is just a normal woman in her thirties, her hair and features that of a stranger. She looks uneasily back at you, " +
                "so with a pale face you apologize, pay your groceries and walk out as fast as your legs can carry you. Perhaps it wasn’t a good idea to skip out on your pills.");
        panel.add(new JScrollPane(textArea), BorderLayout.CENTER);

        JButton nextButton = new JButton("Next");
        nextButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showFinalStory(panel);
            }
        });

        panel.add(nextButton, BorderLayout.SOUTH);
        return panel;
    }

    private void showFinalStory(JPanel panel) {
        panel.removeAll();
        panel.setLayout(new BorderLayout());

        JTextArea textArea = new JTextArea();
        textArea.setWrapStyleWord(true);
        textArea.setLineWrap(true);
        textArea.setEditable(false);
        textArea.setText("With your groceries done, you decide to head back to your home. The rain has turned into a downpour, which slows you down a lot as you struggle through the storm. " +
                "By the time you got back home, it was already noon but you have quite a lot of time left of the day to do whatever you want. Maybe you could even try getting that job you keep dreaming about, " +
                "although filling up those job applications and sending them all always takes up a lot of time.\n\n" +
                "You end up writing the job applications for a while, after which you felt truly spent. You think back on the strange encounter you had tonight and think it best to drink your pills before bed tonight. " +
                "It's better to prevent than to cure, as your mother used to say. The pills are strong so they knock you out practically the second you drop on the bed. You dream of nothing and feel tranquil, " +
                "so much so that you become convinced nothing bad will happen when you wake up again.\n\nThe end.");
        panel.add(new JScrollPane(textArea), BorderLayout.CENTER);

        JButton quitButton = new JButton("Quit");
        quitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });

        panel.add(quitButton, BorderLayout.SOUTH);
        panel.revalidate();
        panel.repaint();
    }
}
