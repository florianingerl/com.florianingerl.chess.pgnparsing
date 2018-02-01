package com.florianingerl.chess.pgnparsing;

import java.io.IOException;

import org.apache.commons.io.IOUtils;

import com.florianingerl.util.regex.CaptureTreeNode;
import com.florianingerl.util.regex.Matcher;
import com.florianingerl.util.regex.Pattern;

public class Main {

	public static void main(String[] args) throws IOException {
		String[] pgnGames = new String[] { "1.e2-e4(1.d2-d4)1...c7-c5",
				"1.e2-e4d7-d52.e4xd5Qd8xd5(2...Ng8-f6)"};

		Pattern p = Pattern.compile(IOUtils.toString(Main.class.getClassLoader().getResourceAsStream("pgn.regex")));

		for (String pgn : pgnGames) {
			Matcher m = p.matcher(pgn);
			m.setMode(Matcher.CAPTURE_TREE);

			if (!m.matches()) {
				System.out.println("This isn't a valid pgn-Game!");
				continue;
			}

			printTreeNode(m.captureTree().getRoot(), 0);
		}
	}

	private static void printTreeNode(CaptureTreeNode node, int tabs) {
		for (int i = 0; i < tabs; ++i)
			System.out.print("\t");
		if (node.getGroupName() != null)
			System.out.print(node.getGroupName());
		else
			System.out.print(node.getGroupNumber());
		if (node.getChildren().isEmpty())
			System.out.print("=" + node.getCapture().getValue());

		System.out.println();
		for (CaptureTreeNode child : node.getChildren()) {
			printTreeNode(child, tabs + 1);
		}
	}

}
