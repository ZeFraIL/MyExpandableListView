# Class Description: CountryCityListAdapter

## 1. General Information
*   **Class Name:** `CountryCityListAdapter`
*   **Type:** Adapter (extends `BaseExpandableListAdapter`)
*   **Purpose:** This class acts as a "translator" or "bridge". An `ExpandableListView` doesn't know how to display a `HashMap` directly. This adapter takes the raw data (countries and cities) and turns it into visual "rows" that the user can see on the screen.
*   **Interaction:** It is created by `MainActivity` and provides views to the `ExpandableListView`.

## 2. Variables (Class Fields)

| Name | Type | Purpose | Where is it used |
| :--- | :--- | :--- | :--- |
| `context` | `Context` | Needed to "inflate" (create) layouts from XML files. | In `getGroupView` and `getChildView`. |
| `countries` | `HashMap<String, ArrayList<String>>` | The actual data containing keys (countries) and lists (cities). | In almost all methods to count and retrieve data. |

## 3. Class Methods

### Method name: `getGroupCount`
*   **Type:** `public`
*   **Return value:** `int` (The number of countries).
*   **What it does:** Tells the list how many "top-level" groups (countries) exist. It returns the size of the HashMap.

### Method name: `getChildrenCount`
*   **Type:** `public`
*   **Return value:** `int` (The number of cities in a specific country).
*   **Parameters:** `groupPosition` (index of the country).
*   **What it does:** Looks up a country by its position and counts how many cities it has.

### Method name: `getGroupView`
*   **Type:** `public`
*   **Return value:** `View` (The visual row for a country).
*   **Detailed Logic:**
    1.  Checks if a recycled view (`convertView`) exists; if not, it "inflates" (creates) a standard layout (`simple_expandable_list_item_1`).
    2.  Finds the `TextView` inside that layout.
    3.  Sets the text size to 25dp and the color to **Red**.
    4.  Sets the text to the Country Name.
*   **When called:** Every time the list needs to show a country row.

### Method name: `getChildView`
*   **Type:** `public`
*   **Return value:** `View` (The visual row for a city).
*   **Detailed Logic:**
    1.  Inflates a layout if needed (`simple_expandable_list_item_2`).
    2.  Sets the text size to 20dp and the color to **Magenta**.
    3.  Sets the text to the City Name.
*   **When called:** Every time a group is expanded and a city row needs to be shown.

## 4. Lifecycle
*(Not applicable for Adapters)*

## 5. Interface Interaction (UI)
*   The adapter manages the internal parts of the `ExpandableListView`. It uses `LayoutInflater` to turn XML templates into real objects that can be displayed.

## 6. Interaction with other components
*   Receives data from `MainActivity` via its **Constructor**.

## 7. General Logic
The `ExpandableListView` asks the adapter questions like: "How many items do you have?" and "What should item #2 look like?". The adapter looks into its `HashMap` and provides the answers and the visual elements.

## 8. Simplified explanation
**Analogy:** Imagine a **Translator**.
*   The **Data** is a book written in a foreign language (raw Java objects).
*   The **User** only speaks "Visuals".
*   The `CountryCityListAdapter` is the **Translator** who reads the book and describes it out loud so the User understands what is there. It draws a big red title for "Chapters" (Countries) and smaller magenta text for "Paragraphs" (Cities).
