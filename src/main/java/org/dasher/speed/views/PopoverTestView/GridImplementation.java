package org.dasher.speed.views.PopoverTestView;


import java.util.ArrayList;
import java.util.List;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Main;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import com.vaadin.flow.dom.Style.FlexDirection;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility;
import org.dasher.speed.base.ui.component.PopoverTooltip;


@Route( RouteConfig.GRID_IMPLEMENTATION_PATH )
@PageTitle( RouteConfig.GRID_IMPLEMENTATION_NAME )
@Menu( order = 2, icon = "vaadin:clipboard-check", title = RouteConfig.GRID_IMPLEMENTATION_NAME )
public class GridImplementation extends Main {
	
	private final Grid<TestItem> testGrid;
	
	
	
	public GridImplementation() {
		var sectionTitle = new H2( RouteConfig.GRID_IMPLEMENTATION_NAME );
		add( sectionTitle );
		
		var problemDescriptionOne = new Div(
		"1. Using a ComponentRenderer for rendering tooltips containing HTML in the grid is overkill. Especially since ComponentColumns have significant performance implications in large grids."
		);
		var problemDescriptionTwo = new Div(
		"2. The popovers mounted in grids don't close reliably. This is a bit tougher to reproduce but does happen quite frequently. The best way to reproduce this is to sort the Price Column and quickly move the mouse sideways towards and over the \"Name\" column."
		);
		problemDescriptionTwo.getStyle().setMarginTop( "1rem" );
		Div probContainer = new Div();
		probContainer.getStyle().setFlexDirection( FlexDirection.COLUMN );
		probContainer.add( problemDescriptionOne );
		probContainer.add( problemDescriptionTwo );
		add( probContainer );
		
		
		testGrid = new Grid<>( TestItem.class );
		testGrid.setItems( generateTestItems( 1000 ) );

		Span nameHeader = new Span( "Name" );
		PopoverTooltip.createOrRenew( nameHeader, "<span>Tooltip for Name</span>" );
		
		Span priceHeader = new Span( "Price" );
		PopoverTooltip.createOrRenew( priceHeader, "<span>Tooltip for Price</span>" );
		
		Span quantityHeader = new Span( "Quantity" );
		PopoverTooltip.createOrRenew( quantityHeader, "<span>Tooltip for Quantity</span>" );
		
		Span availableHeader = new Span( "Available" );
		PopoverTooltip.createOrRenew( availableHeader, "<span>Tooltip for Available</span>" );
		
		Span dateHeader = new Span( "Date" );
		PopoverTooltip.createOrRenew( dateHeader, "<span>Tooltip for Date</span>" );
		
		Span descriptionHeader = new Span( "Description" );
		PopoverTooltip.createOrRenew( descriptionHeader, "<span>Tooltip for Description</span>" );

		testGrid.getColumnByKey( "name" ).setHeader( nameHeader );
		testGrid.getColumnByKey( "price" ).setHeader( priceHeader );
		testGrid.getColumnByKey( "quantity" ).setHeader( quantityHeader );
		testGrid.getColumnByKey( "available" ).setHeader( availableHeader );
		testGrid.getColumnByKey( "date" ).setHeader( dateHeader );
		testGrid.getColumnByKey( "description" ).setHeader( descriptionHeader );

		Div customHeaderRow = new Div();
		customHeaderRow.getStyle().set( "display", "flex" );
		customHeaderRow.getStyle().set( "justify-content", "space-between" );
		
		Span customHeader1 = new Span( "Custom Header 1" );
		PopoverTooltip.createOrRenew( customHeader1, "<span>Tooltip for Custom Header 1</span>" );
		
		Span customHeader2 = new Span( "Custom Header 2" );
		PopoverTooltip.createOrRenew( customHeader2, "<span>Tooltip for Custom Header 2</span>" );
		
		Span customHeader3 = new Span( "Custom Header 3" );
		PopoverTooltip.createOrRenew( customHeader3, "<span>Tooltip for Custom Header 3</span>" );
		
		customHeaderRow.add( customHeader1, customHeader2, customHeader3 );

		testGrid.prependHeaderRow().join(
		testGrid.getColumnByKey( "name" ),
		testGrid.getColumnByKey( "price" ),
		testGrid.getColumnByKey( "quantity" ),
		testGrid.getColumnByKey( "available" ),
		testGrid.getColumnByKey( "date" ),
		testGrid.getColumnByKey( "description" )
		).setComponent( customHeaderRow );

		testGrid.getColumnByKey( "date" )
		.setRenderer( new ComponentRenderer<>( item -> {
			var datePicker = new DatePicker( item.getDate() );
			PopoverTooltip.createOrRenew( datePicker,
			"<span>I am a <b>html</b> tooltip<br>that will <b>not</b> close when the Date Picker is closed. Also while the datepicker is open.</span>" );
			return datePicker;
		} ) );
		
		testGrid.getColumnByKey( "name" )
		.setRenderer( new ComponentRenderer<>( item -> {
			var nameComponent = new Span( item.getName() );
			nameComponent.addClickListener( e -> {
				Dialog dialog = new Dialog();
				dialog.add( new Text( "I am a dialog that will close when the name is clicked." ) );
				dialog.open();
			} );
			
			PopoverTooltip.createOrRenew( nameComponent, "<span>" + "I must support HTML: " + "<b>" + item.getDescription() + "</b>" + "</span>" );
			return nameComponent;
		} ) );
		
		testGrid.getColumnByKey( "price" )
		.setTooltipGenerator( item -> item.getDescription() );
		
		testGrid.setColumnOrder( testGrid.getColumnByKey( "name" ), testGrid.getColumnByKey( "price" ), testGrid.getColumnByKey( "quantity" ), testGrid.getColumnByKey( "available" ),
		testGrid.getColumnByKey( "date" ), testGrid.getColumnByKey( "description" ) );
		
		setHeight( "500px" );
		addClassNames( LumoUtility.BoxSizing.BORDER, LumoUtility.Display.FLEX, LumoUtility.FlexDirection.COLUMN, LumoUtility.Padding.MEDIUM, LumoUtility.Gap.SMALL );
		
		add( testGrid );
	}
	
	
	private List<TestItem> generateTestItems( int count ) {
		List<TestItem> items = new ArrayList<>();
		for( int i = 0; i < count; i++ ) {
			items.add( TestItem.createRandom() );
		}
		return items;
	}
	
}



