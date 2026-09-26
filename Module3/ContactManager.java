import java.util.*; 

public class ContactManager { 
 
    public static void main(String[] args) { 
 
        HashMap<String, Contact> contacts = new HashMap<>(); 
 
        // Step 4: add contacts here 
        contacts.put("Dawt Sung",new Contact("Dawt Sung","913 735 0354"));
        contacts.put("Nathan Kap",new Contact("Nathan Kap","137 478 7226"));
        contacts.put("Naw Phaw",new Contact("Naw Phaw","713 358 6767"));
        contacts.put("Ci Kap",new Contact("Ci Kap","371 730 2829"));
        contacts.put("Police",new Contact("Police","911"));

        // Step 5: look up a contact 
        Contact contact = contacts.get("Dawt Sung");

        if (contact == null) {
            System.out.println("Contact not found");
        } else {
            System.out.println(contact);
        }

        Contact missingContact = contacts.get("Mr. Guy");

        if (missingContact == null) {
            System.out.println("Contact not found");
        } else {
            System.out.println(missingContact);
        }
        // Step 6: print sorted list 
        ArrayList<Contact> sorted = new ArrayList<>(contacts.values());
        sorted.sort((a, b) -> a.getName().compareTo(b.getName()));

        System.out.println("=== All Contacts ===");

        for (Contact sortedContact : sorted) {
            System.out.println(sortedContact);
        }
    } 
}