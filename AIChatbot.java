import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;

public class AIChatbot extends JFrame {
    private JTextArea chatArea;
    private JTextField inputField;
    private JButton sendButton;
    private HashMap<String, String> responses;

    public AIChatbot() {
        setTitle("CodeAlpha - AI Chatbot");
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Responses setup
        setupResponses();

        chatArea = new JTextArea();
        chatArea.setEditable(false);
        chatArea.setFont(new Font("Arial", Font.PLAIN, 14));
        chatArea.setBackground(new Color(240, 248, 255));
        JScrollPane scrollPane = new JScrollPane(chatArea);

        JPanel inputPanel = new JPanel(new BorderLayout());
        inputField = new JTextField();
        inputField.setFont(new Font("Arial", Font.PLAIN, 14));
        sendButton = new JButton("Send");
        sendButton.setBackground(new Color(0, 123, 255));
        sendButton.setForeground(Color.WHITE);

        inputPanel.add(inputField, BorderLayout.CENTER);
        inputPanel.add(sendButton, BorderLayout.EAST);

        add(scrollPane, BorderLayout.CENTER);
        add(inputPanel, BorderLayout.SOUTH);

        chatArea.append("Bot: Hello! I am your AI Assistant. How can I help you?\n\n");

        // Action Listeners
        sendButton.addActionListener(e -> sendMessage());
        inputField.addActionListener(e -> sendMessage());

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void setupResponses() {
        responses = new HashMap<>();
        responses.put("hi", "Hello! How can I help you today?");
        responses.put("hello", "Hi there! What can I do for you?");
        responses.put("how are you", "I'm just a bot, but I'm doing great! How about you?");
        responses.put("your name", "I am CodeAlpha AI Chatbot created as part of Task 3.");
        responses.put("what is java", "Java is a popular object-oriented programming language used to build apps.");
        responses.put("help", "I can answer simple questions. Try: hi, your name, what is java, bye");
        responses.put("bye", "Goodbye! Thanks for chatting. Have a great day!");
        responses.put("codealpha", "CodeAlpha is providing amazing internships for students to learn and grow!");
    }

    private void sendMessage() {
        String userInput = inputField.getText().trim().toLowerCase();
        if (userInput.isEmpty()) return;

        chatArea.append("You: " + inputField.getText() + "\n");

        String botResponse = "Sorry, I didn't understand that. Type 'help' to see what I can do.";
        for (String key : responses.keySet()) {
            if (userInput.contains(key)) {
                botResponse = responses.get(key);
                break;
            }
        }

        chatArea.append("Bot: " + botResponse + "\n\n");
        inputField.setText("");
    }

    public static void main(String[] args) {
        new AIChatbot();
    }
}