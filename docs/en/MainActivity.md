# Class Description: MainActivity

## 1. General Information
*   **Class Name:** `MainActivity`
*   **Type:** Activity
*   **Purpose:** This is the main screen of the application. It acts as the "brain" that coordinates the data (lists of countries and cities) and the visual component (`ExpandableListView`). It is responsible for starting the app, preparing the information to be shown, and responding when the user clicks on items in the list.
*   **Interaction:** It creates and uses the `CountryCityListAdapter` to populate the list. It also interacts with the Android system to show small messages called `Toast`.

## 2. Variables (Class Fields)

| Name | Type | Purpose | Where is it used |
| :--- | :--- | :--- | :--- |
| `context` | `Context` | Stores information about the application environment. | In `Toast` messages and adapter initialization. |
| `countryCityMap` | `HashMap<String, ArrayList<String>>` | A dictionary-like structure where each country name (Key) is linked to a list of its cities (Value). | In `initData()`, `initElements()`, and when clicking on items. |
| `countries_list` | `ArrayList<String>` | A simple list containing the names of the countries (USA, UK, Poland). | In `initData()` and listeners to identify which country was clicked. |
| `citiesInUSA` | `ArrayList<String>` | Stores cities belonging to the USA. | In `initData()`. |
| `citiesInUK` | `ArrayList<String>` | Stores cities belonging to the UK. | In `initData()`. |
| `citiesInPoland` | `ArrayList<String>` | Stores cities belonging to Poland. | In `initData()`. |
| `elvCountryCity` | `ExpandableListView` | The visual component (View) that displays the expandable list on the screen. | In `initElements()` and for setting up click listeners. |
| `adapter` | `CountryCityListAdapter` | The bridge that takes the data from the maps/lists and puts it into the `ExpandableListView`. | In `initElements()`. |

## 3. Class Methods

### Method name: `onCreate`
*   **Type:** `protected`
*   **Return value:** `void` (returns nothing)
*   **Parameters:**
    | Name | Type | Description |
    | :--- | :--- | :--- |
    | `savedInstanceState` | `Bundle` | Contains data from a previous session (if the app was restarted). |
*   **Detailed Logic:**
    1.  Calls `super.onCreate` to run standard Android startup code.
    2.  Sets the visual layout using `setContentView(R.layout.activity_main)`.
    3.  Calls `initData()` to prepare the lists.
    4.  Sets up a **GroupClickListener**: when a country name is clicked, a `Toast` pops up with that country's name.
    5.  Sets up a **ChildClickListener**: when a city name is clicked, a `Toast` pops up with that city's name.
*   **When called:** Automatically by the Android system when the app starts.
*   **Important:** This is where everything begins. If you forget to call `setContentView`, the screen will be empty.

### Method name: `initData`
*   **Type:** `private`
*   **Return value:** `void`
*   **Parameters:** None
*   **Detailed Logic:**
    1.  Creates the `countries_list` and adds "USA", "Great Britain", and "Poland".
    2.  Creates the `countryCityMap`.
    3.  Creates separate `ArrayList`s for cities in each country and fills them.
    4.  Links each city list to its country in the `countryCityMap`.
    5.  Finally, calls `initElements()`.
*   **When called:** Manually from `onCreate()`.

### Method name: `initElements`
*   **Type:** `private`
*   **Return value:** `void`
*   **Parameters:** None
*   **Detailed Logic:**
    1.  Sets `context = this` (referring to this Activity).
    2.  Links the Java variable `elvCountryCity` to the XML element with ID `elvCountryCity` using `findViewById`.
    3.  If the view is found, it creates a new `CountryCityListAdapter` and gives it the data.
    4.  Connects the adapter to the `ExpandableListView`.
*   **When called:** At the end of `initData()`.

## 4. Lifecycle
*   **`onCreate()`**: Called when the Activity is first created. This is where we initialize the UI and the data. In this class, it's the only lifecycle method used.

## 5. Interface Interaction (UI)
*   **Elements:** `ExpandableListView` (a list that can expand/collapse groups).
*   **Connection:** Uses `findViewById(R.id.elvCountryCity)` to find the list in the layout file.
*   **Events:**
    *   `onGroupClick`: Handles clicks on countries.
    *   `onChildClick`: Handles clicks on cities.

## 6. Interaction with other components
*   **Data Transfer:** Passes the `HashMap` and `ArrayList` to the `CountryCityListAdapter`.

## 7. General Logic
The class follows these steps: **Start -> Fill Data -> Find UI Element -> Attach Adapter -> Listen for Clicks**. It essentially prepares a "menu" and waits for the user to interact with it.

## 8. Simplified explanation
**Analogy:** Imagine a **Restaurant Menu**.
*   The `MainActivity` is the **Manager**.
*   The `countries_list` is the list of **Categories** (Appetizers, Main Course, Desserts).
*   The `countryCityMap` is the **Detailed Menu** showing which dishes belong to which category.
*   The `ExpandableListView` is the **Physical Menu Card** the customer holds.
*   The `Adapter` is the **Waiter** who takes the information from the kitchen (Data) and brings it to the customer's table (Screen).

When the customer (User) taps a category, the Manager (Activity) tells them what they tapped via a small note (Toast).
