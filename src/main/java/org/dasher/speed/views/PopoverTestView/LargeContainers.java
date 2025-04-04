package org.dasher.speed.views.PopoverTestView;


import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Main;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.popover.PopoverPosition;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility;
import com.vaadin.flow.theme.lumo.LumoUtility.Padding;
import org.dasher.speed.base.ui.component.PopoverTooltip;


@Route( RouteConfig.LARGE_CONTAINERS_PATH )
@PageTitle( RouteConfig.LARGE_CONTAINERS_NAME )
@Menu( order = 1, icon = "vaadin:clipboard-check", title = RouteConfig.LARGE_CONTAINERS_NAME )
public class LargeContainers extends Main {
	
	private static final String LARGE_CONTAINER_SIZE = "800px";
	
	
	private class MySpan extends Span {
		
		public MySpan( String text ) {
			super( text );
			getStyle().setMaxWidth( LARGE_CONTAINER_SIZE );
			getStyle().setMarginBottom( "1rem" );
		}
		
	}
	
	public LargeContainers() {
		add( new H2( RouteConfig.LARGE_CONTAINERS_NAME ) );
		add( new MySpan(
		"1. The tooltip is always placed outside containers, which can be problematic, especially for large ones. This may cause the tooltip to appear away from the user's focus, leading to a poor experience. It would be helpful to have an option to place the tooltip at the cursor location." ) );
		add( new MySpan(
		"2. When containers or components are nested, multiple tooltips may appear simultaneously, which can be confusing. The Popover implementation currently displays multiple tooltips for nested components. Hover over the button below to see a demonstration." ) );
		
		VerticalLayout largeContainer = new VerticalLayout();
		largeContainer.getStyle().setBackgroundColor( "#f2f2f2" );
		largeContainer.setHeight( "400px" );
		largeContainer.setWidth( LARGE_CONTAINER_SIZE );
		PopoverTooltip.createOrRenew( largeContainer, "<span>I am a Tooltip for the <b>Large Container</b></span>", PopoverPosition.BOTTOM_END );
		Button btn = new Button( "Click me" );
		PopoverTooltip.createOrRenew( btn, "<span>I am a Tooltip for the <b>button component</b></span>" );
		largeContainer.add( btn );
		add( largeContainer );
		addClassNames( LumoUtility.BoxSizing.BORDER, LumoUtility.Display.FLEX, LumoUtility.FlexDirection.COLUMN, Padding.MEDIUM, LumoUtility.Gap.SMALL );
	}
	
	
	
}
