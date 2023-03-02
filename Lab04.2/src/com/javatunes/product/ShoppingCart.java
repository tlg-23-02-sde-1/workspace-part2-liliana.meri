/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.javatunes.product;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/*
* The *T* is really going to be something like MusicItem
* ShoppingCart<MusicItem> cart = ... // whats the T?     MusicItem
* shoppingCart<MusicPLayer> cart = ... // whats the T?    MusicItem
*/

// only 'product' types allowed in SHOPPING CART (i.e., no employees, TaxPayers, etc)
public class ShoppingCart<T extends Product> {

    // storage for the cart's contents
    private final Collection<T> items = new ArrayList<T>();  // diamond not used here just to emphasize the T

    public double total() {
        double result = 0.0;
        for ( T item : items) {
            result += item.getPrice();
        }
        return result;
    }

    public Collection<T> allItems() {
        return Collections.unmodifiableCollection(items); // read-only
    }

    public int size() {
        return items.size();
    }

    public void addItem(T item) {
        items.add(item);
    }

    public void removeItem(T item) {
        items.remove(item);
    }
}