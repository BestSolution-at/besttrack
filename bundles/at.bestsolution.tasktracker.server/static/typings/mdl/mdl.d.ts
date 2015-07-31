interface MDL {
	upgradeDom() : void;
	upgradeElement(node : Node) : void
	upgradeElements(nodeList : Node[]) : void
	upgradeAllRegistered() : void
	downgradeElements() : void
}

declare var componentHandler: MDL;