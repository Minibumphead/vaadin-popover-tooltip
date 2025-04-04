# Summary / Considerations

Our Vaadin application makes extensive use of tooltips containing HTML, a practice historically carried over from Vaadin v8. Many of these tooltips are implemented in components like [Grid.java](https://github.com/vaadin/flow/blob/main/vaadin-grid-flow/src/main/java/com/vaadin/flow/component/grid/Grid.java) and [TreeGrid.java](https://github.com/vaadin/flow/blob/main/vaadin-grid-flow/src/main/java/com/vaadin/flow/component/treegrid/TreeGrid.java).

We have experimented with using the Popover Component ([PopoverTooltip.java](./src/main/java/org/dasher/speed/base/ui/component/PopoverTooltip.java)) to address tooltip requirements. However, this approach has proven to be too resource-intensive, particularly for grids. We are seeking a more lightweight and efficient solution.

## Performance Issues with `ComponentRenderer` in Grids

Using `ComponentRenderer` to render tooltips containing HTML in grids introduces significant performance overhead, especially in large datasets. This approach is not optimal for high-performance applications.

## Unreliable Closing of Popovers in Grids

Popovers mounted in grids do not close reliably, particularly when the mouse moves between the sidebar menu item "Grid implementation" and "Custom Header 1." This behavior negatively impacts usability.

## Tooltip Placement in Large Containers

Tooltips are always placed outside their parent containers, which can be problematic in large containers. This placement often causes tooltips to appear far from the user's focus, leading to a suboptimal user experience.

Additionally, nested containers or components can result in multiple tooltips appearing simultaneously, which can confuse users.

## Popover Behavior with DatePicker

The popover remains open when the DatePicker is opened. Furthermore, it does not close when the DatePicker is dismissed by clicking outside of it. This behavior creates inconsistencies in the user interface.
