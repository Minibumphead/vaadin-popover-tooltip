package org.dasher.speed.views.PopoverTestView;

public class RouteConfig {
	
	public static final String GENERAL_ISSUE_NAME = "Date Picker";
	public static final String GENERAL_ISSUE_PATH = "";
	public static final String LARGE_CONTAINERS_NAME = "Large Containers";
	public static final String LARGE_CONTAINERS_PATH = "large-containers";
	public static final String GRID_IMPLEMENTATION_NAME = "Grid Implementation";
	public static final String GRID_IMPLEMENTATION_PATH = "grid-implementation";
	public static final String TREE_GRID_IMPLEMENTATION_NAME = "TreeGrid Implementation";
	public static final String TREE_GRID_IMPLEMENTATION_PATH = "treegrid-implementation";
	
	public static final Route LARGE_CONTAINERS = new Route( LARGE_CONTAINERS_NAME, LARGE_CONTAINERS_PATH );
	public static final Route GRID_IMPLEMENTATION = new Route( GRID_IMPLEMENTATION_NAME, GRID_IMPLEMENTATION_PATH );
	public static final Route TREE_GRID_IMPLEMENTATION = new Route( TREE_GRID_IMPLEMENTATION_NAME, TREE_GRID_IMPLEMENTATION_PATH );
	
	
	public record Route( String name, String path ) {}
	
}
