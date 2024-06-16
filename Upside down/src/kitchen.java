import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class kitchen extends JFrame {
    private CardLayout cardLayout;
    private JPanel contentPanel;

    public kitchen() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 600, 400);
        cardLayout = new CardLayout();
        contentPanel = new JPanel(cardLayout);

        // First panel with introductory text
        JPanel panel1 = createTextPanel(
                "You chose to go to the kitchen. After all, you are hungry and it is always a good idea to start your day off with breakfast. " +
                "As you head to your mediocre kitchen and search the refrigerator and cupboards, you find that you only have some plain bread and marmalade left. " +
                "You are going to have to go shopping after this. First things first, you make yourself a boring old sandwich with the bread and the marmalade. " +
                "The bread is a little stale but the marmalade makes it feel less dry.\n\n+ 3 hunger\nYour hunger is now 7/10",
                "Next",
                e -> cardLayout.show(contentPanel, "Panel2")
        );
        contentPanel.add(panel1, "Panel1");

        // Second panel with text and buttons
        JPanel panel2 = createTextPanel(
                "While you eat, you decide to browse through the news paper you bought yesterday for this exact purpose. " +
                "It’s your little ritual, even if it makes you feel a little old for doing it. The articles were pretty boring in the first couple of pages, " +
                "but you never expect much for something that is just supposed to eat up some time. ‘This superstar cheated on this other super star’, " +
                "‘Our economy is in a crisis’, the usual. It is on the fourth page that an article about a recent murder caught your attention. " +
                "It was a burglary at gunpoint at a family restaurant you used to frequent back in the day, where a man came to steal some cash and one of the chefs attacked him with a knife. " +
                "The guy was shot dead, and caused the murderer to freak out and escape without taking any money.\n\nThis makes you feel…",
                null,
                null
        );
        JPanel buttonPanel2 = new JPanel();
        JButton sadButton = new JButton("Sad");
        JButton angryButton = new JButton("Angry");
        JButton upsetButton = new JButton("Upset at the gun man’s incompetence");

        buttonPanel2.add(sadButton);
        buttonPanel2.add(angryButton);
        buttonPanel2.add(upsetButton);
        panel2.add(buttonPanel2, BorderLayout.SOUTH);

        contentPanel.add(panel2, "Panel2");

        // Third panel for "Sad" option
        JPanel panel3 = createTextPanel(
                "You feel sad. Sad about the chef’s noble attempt at protecting his co-workers leading to such a gruesome murder, while the burglar managed to make a run for it. " +
                "You read how the chef had a family at home that is mourning the loss of their father and husband, and his elder mother is planning on hosting an event in his honor, " +
                "where any donations towards his funeral and his family’s aid is greatly encouraged. You feel a bit of tears well in your eyes, but you decided not too long ago " +
                "that you shouldn’t meddle in other people’s business, even if you feel like you ought to help.\n\n" +
                "Briefly your morbid thoughts wonder whether getting killed with a gun or a knife is worse.",
                null,
                null
        );
        JPanel buttonPanel3 = new JPanel();
        JButton gunButton = new JButton("Gun");
        JButton knifeButton = new JButton("Knife");

        buttonPanel3.add(gunButton);
        buttonPanel3.add(knifeButton);
        panel3.add(buttonPanel3, BorderLayout.SOUTH);

        contentPanel.add(panel3, "Panel3");

        // Panel for "Angry" option
        JPanel panelAngry = createTextPanel(
                "You feel angry at the injustice of it all. How an innocent person just wanting to protect his family establishment, hard-earned money and co-workers earned him such a terrible end, " +
                "while the perpetrator managed to run away scot-free. You wish there was more justice in this world and that evildoers didn’t have fate on their side just because they have a weapon and the other person does not at the wrong time and wrong place.\n\n" +
                "Briefly your morbid thoughts wonder whether getting killed with a gun or a knife is worse.",
                null,
                null
        );
        JPanel buttonPanelAngry = new JPanel();
        JButton gunButtonAngry = new JButton("Gun");
        JButton knifeButtonAngry = new JButton("Knife");

        buttonPanelAngry.add(gunButtonAngry);
        buttonPanelAngry.add(knifeButtonAngry);
        panelAngry.add(buttonPanelAngry, BorderLayout.SOUTH);

        contentPanel.add(panelAngry, "PanelAngry");

        // Panel for "Upset" option
        JPanel panelUpset = createTextPanel(
                "How could this guy mess up so bad at such a golden opportunity? If he already went so far as to kill a guy, why didn’t he just finish the job he started and stole all their money? " +
                "It’s not like anybody else is going to try the same trick as that chef after they saw the result of such a foolish action. The fact that the man chose to run away right at the finish line despite all he sacrificed to get to that point fills you with utter disgust. Not towards his actions, but towards his lack of brains.\n\n" +
                "Briefly your morbid thoughts wonder whether getting killed with a gun or a knife is worse.",
                null,
                null
        );
        JPanel buttonPanelUpset = new JPanel();
        JButton gunButtonUpset = new JButton("Gun");
        JButton knifeButtonUpset = new JButton("Knife");

        buttonPanelUpset.add(gunButtonUpset);
        buttonPanelUpset.add(knifeButtonUpset);
        panelUpset.add(buttonPanelUpset, BorderLayout.SOUTH);

        contentPanel.add(panelUpset, "PanelUpset");

        // Panel for "Gun" option
        JPanel panelGun = createTextPanel(
                "Imagining a clear shot passing through your entire body while you are powerless to defend yourself gives you the creeps. " +
                "At least with a knife you have a chance to overpower your opponent before he gets you in a vital area. With guns you would fall to your knees in pain the second a shot hits you anywhere, " +
                "and the hopes of getting close to the attacker is close to none. Decidedly, you would take the chances with a knife rather than a weapon you have no chance against without a gun being in your possession as well.",
                "Next",
                e -> cardLayout.show(contentPanel, "PanelDecision")
        );
        contentPanel.add(panelGun, "PanelGun");

        // Panel for "Knife" option
        JPanel panelKnife = createTextPanel(
                "Imagining a puncture wound is already terrible enough, but the thought of you not immediately dying from a single stab is even worse. " +
                "Getting pierced over and over again while you cry out in agony will certainly be the stuff of your nightmares for nights to come. " +
                "In hindsight, getting shot quickly and without the feeling of metal sinking in and out of you repeatedly is definitely the better choice out of the two.",
                "Next",
                e -> cardLayout.show(contentPanel, "PanelDecision")
        );
        contentPanel.add(panelKnife, "PanelKnife");

        // Final decision panel
        JPanel panelDecision = new JPanel(new BorderLayout());
        JLabel decisionLabel = new JLabel("Where will you go now?", SwingConstants.CENTER);
        decisionLabel.setFont(new Font("Serif", Font.PLAIN, 20));
        panelDecision.add(decisionLabel, BorderLayout.CENTER);

        JPanel decisionButtonPanel = new JPanel();
        JButton outsideButton = new JButton("Outside");
        outsideButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		outside outside = new outside();
				outside.main(new String[0]);
				dispose();
        	}
        });
        JButton backToBedButton = new JButton("Back to bed, you want to snooze for a while longer");

        decisionButtonPanel.add(outsideButton);
        decisionButtonPanel.add(backToBedButton);
        panelDecision.add(decisionButtonPanel, BorderLayout.SOUTH);

        contentPanel.add(panelDecision, "PanelDecision");

        // Add contentPanel to JFrame
        getContentPane().add(contentPanel);

        // Button Actions
        sadButton.addActionListener(e -> cardLayout.show(contentPanel, "Panel3"));
        angryButton.addActionListener(e -> cardLayout.show(contentPanel, "PanelAngry"));
        upsetButton.addActionListener(e -> cardLayout.show(contentPanel, "PanelUpset"));

        gunButton.addActionListener(e -> cardLayout.show(contentPanel, "PanelGun"));
        knifeButton.addActionListener(e -> cardLayout.show(contentPanel, "PanelKnife"));

        gunButtonAngry.addActionListener(e -> cardLayout.show(contentPanel, "PanelGun"));
        knifeButtonAngry.addActionListener(e -> cardLayout.show(contentPanel, "PanelKnife"));

        gunButtonUpset.addActionListener(e -> cardLayout.show(contentPanel, "PanelGun"));
        knifeButtonUpset.addActionListener(e -> cardLayout.show(contentPanel, "PanelKnife"));

        backToBedButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(contentPanel, "You died in sleep GG");
            System.exit(0);
        });

        // Set initial panel
        cardLayout.show(contentPanel, "Panel1");
    }

    private JPanel createTextPanel(String text, String buttonText, ActionListener actionListener) {
        JPanel panel = new JPanel(new BorderLayout());
        JTextArea textArea = new JTextArea();
        textArea.setWrapStyleWord(true);
        textArea.setLineWrap(true);
        textArea.setEditable(false);
        textArea.setText(text);
        panel.add(new JScrollPane(textArea), BorderLayout.CENTER);
        if (buttonText != null && actionListener != null) {
            JButton button = new JButton(buttonText);
            button.addActionListener(actionListener);
            panel.add(button, BorderLayout.SOUTH);
        }
        return panel;
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                kitchen frame = new kitchen();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
