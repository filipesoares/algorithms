package com.github.filipesoares.algorithms;

import java.util.ArrayList;
import java.util.List;

public final class App {

    private App() {
    }

	public static List<String> sortBoxes(int numberOfBoxes, List<String> boxes) {

		final List<String> oldboxes = new ArrayList<>();
		final List<String> newboxes = new ArrayList<>();

		boxes.forEach(box -> {
			if (box.split(" ")[1].matches("-?\\d+(\\.\\d+)?")) {
				newboxes.add(box);
			} else {
				oldboxes.add(box);
			}
		});

		oldboxes.sort((p1, p2) -> {
			return p1.substring(p1.indexOf(" ")).equals(p2.substring(p2.indexOf(" "))) ? p1.compareTo(p2)
					: p1.substring(p1.indexOf(" ")).compareTo(p2.substring(p2.indexOf(" ")));
		});
		
		final List<String> orderedList = new ArrayList<>();
		orderedList.addAll(oldboxes);
		orderedList.addAll(newboxes);

		return orderedList;
	}

	public static void main(String[] args) throws Exception {

		List<String> boxes = new ArrayList<>();
		boxes.add("ykc 82 01");
		boxes.add("eo first qpx");
		boxes.add("09z cat hamster");
		boxes.add("06f 12 25 6");
		boxes.add("az0 first qpx");
		boxes.add("236 cat dog rabbit snake");

		sortBoxes(boxes.size(), boxes);

    }
    
}
