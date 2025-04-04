package org.dasher.speed.views.PopoverTestView;

import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Main;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility;
import org.dasher.speed.base.ui.component.PopoverTooltip;


@PageTitle( "PopoverTestView / Summary" )
@Menu( order = 0, icon = "vaadin:clipboard-check", title = RouteConfig.GENERAL_ISSUE_NAME )
@Route( RouteConfig.GENERAL_ISSUE_PATH )
public class PopoverTestView extends Main {
	
	private class MySpan extends Span {
		
		public MySpan( String text ) {
			super( text );
			getStyle().setMaxWidth( "800px" );
			getStyle().setMarginBottom( "1rem" );
		}
		
	}
	
	public PopoverTestView() {
		add( new H2( RouteConfig.LARGE_CONTAINERS_NAME ) );
		
		add( new MySpan( "For certain components the popover implementation of the tooltip doesn't work as expected. Hover the date picker down below for an example." ) );
		add( new MySpan( "Problem 1: The Popover remains open when the date picker is opened." ) );
		add( new MySpan( "Problem 2: The Popover remains open when the date picker is closed by click outside." ) );
		Span datePickerContainer = new Span();
		datePickerContainer.getStyle().setMaxWidth( "200px" );
		DatePicker datePicker = new DatePicker();
		PopoverTooltip.createOrRenew( datePicker, "<span>Select a <b>date</b></span>" );
		datePickerContainer.add( datePicker );
		add( datePickerContainer );
		addClassNames( LumoUtility.BoxSizing.BORDER, LumoUtility.Display.FLEX, LumoUtility.FlexDirection.COLUMN, LumoUtility.Padding.MEDIUM, LumoUtility.Gap.SMALL );
		
	}
	
	
}
