INSERT INTO sector (id, name, parent_sector_id) VALUES
(1, 'sector.manufacturing', null),
	(4, 'sector.construction-materials', 1),
	(5, 'sector.electronics-and-optics', 1),
	(6, 'sector.food-and-beverage', 1),
		(23, 'sector.bakery-and-confectionery-products', 6),
		(24, 'sector.beverages', 6),
		(25, 'sector.fish-and-fish-products', 6),
		(26, 'sector.meat-and-meat-products', 6),
		(27, 'sector.milk-and-dairy-products', 6),
		(28, 'sector.other-food-and-beverage', 6),
		(29, 'sector.sweets-and-snack-food', 6),
	(7, 'sector.furniture', 1),
		(30, 'sector.bathroom-or-sauna', 7),
		(31, 'sector.bedroom', 7),
		(32, 'sector.childrens-room', 7),
		(33, 'sector.kitchen', 7),
		(34, 'sector.living-room', 7),
		(35, 'sector.office', 7),
		(36, 'sector.other-furniture', 7),
		(37, 'sector.outdoor', 7),
		(38, 'sector.project-furniture', 7),
	(8, 'sector.machinery', 1),
		(39, 'sector.machinery-components', 8),
		(40, 'sector.machinery-equipment-or-tools', 8),
		(41, 'sector.manufacture-of-machinery', 8),
		(42, 'sector.maritime', 8),
			(70, 'sector.aluminium-and-steel-workboats', 42),
			(71, 'sector.boat-or-yaht-building', 42),
			(72, 'sector.ship-repair-and-conversion', 42),
		(43, 'sector.metal-structures', 8),
		(44, 'sector.other-machinery', 8),
		(45, 'sector.repair-and-maintenance-service', 8),
	(9, 'sector.metalworking', 1),
		(46, 'sector.construction-of-meta-structures', 9),
		(47, 'sector.houses-and-buildings', 9),
		(48, 'sector.metal-products', 9),
		(49, 'sector.metal-works', 9),
			(73, 'sector.cnc-machining', 48),
			(74, 'sector.forgings-fasteners', 48),
			(75, 'sector.gas-plasma-laser-cutting', 48),
			(76, 'sector.mig-tig-aluminium-welding', 48),
	(10, 'sector.plastic-and-rubber', 1),
		(50, 'sector.packaging', 10),
		(51, 'sector.plastic-goods', 10),
		(52, 'sector.plastic-processing-technology', 10),
			(77, 'sector.blowing', 51),
			(78, 'sector.moulding', 51),
			(79, 'sector.plastics-welding-and-processing', 51),
		(53, 'sector.plastic-profiles', 10),
	(11, 'sector.printing', 1),
		(54, 'sector.advertising', 11),
		(55, 'sector.book-or-periodicals-printing', 11),
		(56, 'sector.labelling-and-packaging-printing', 11),
	(12, 'sector.textile-and-clothing', 1),
		(57, 'sector.clothing', 12),
		(58, 'sector.textile', 12),
	(13, 'sector.wood', 1),
		(59, 'sector.other-wood', 13),
		(60, 'sector.wooden-building-materials', 13),
		(61, 'sector.wooden-houses', 13),
(2, 'sector.other', null),
	(14, 'sector.creative-industries', 2),
	(15, 'sector.energy-technology', 2),
	(16, 'sector.environment', 2),
(3, 'sector.service', null),
	(17, 'sector.business-services', 3),
	(18, 'sector.engineering', 3),
	(19, 'sector.it-and-telco', 3),
		(62, 'sector.data-processing-web-portals-e-marketing', 19),
		(63, 'sector.programming-consultancy', 19),
		(64, 'sector.software-hardware', 19),
		(65, 'sector.telco', 19),
	(20, 'sector.tourism', 3),
	(21, 'sector.translation-services', 3),
	(22, 'sector.transport-and-logistics', 3),
		(66, 'sector.air', 22),
		(67, 'sector.rail', 22),
		(68, 'sector.road', 22),
		(69, 'sector.water', 22);