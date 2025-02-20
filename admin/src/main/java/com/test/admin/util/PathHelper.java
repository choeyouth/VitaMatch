package com.test.admin.util;

public class PathHelper {

	private static String getPath(String boardType, String roleType) {
		return String.format("page/%s/%s", boardType, roleType);
	}

	private static String redirectPath(String boardType, Long seq) {
		if (seq != null) {
			return String.format("redirect:/%s/%s", boardType, seq);
		}
		return String.format("redirect:/%s", boardType);
	}

	public static String getListPath(String boardType) {
		return getPath(boardType, "list");
	}

	public static String getWritePath(String boardType) {
		return getPath(boardType, "write");
	}

	public static String getDetailPath(String boardType) {
		return getPath(boardType, "detail");
	}

	public static String getEditPath(String boardType) {
		return getPath(boardType, "edit");
	}

	public static String redirectListPath(String boardType) {
		return redirectPath(boardType, null);
	}
	
	public static String redirectDetailPath(String boardType, Long seq) {
		return redirectPath(boardType, seq);
	}
}
