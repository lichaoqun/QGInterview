class Solution {
	public void preorderTraversal() {
		Stack<Node<E>> stack = new Stack<>();
		Node<E>curNode = root;
		while (true) {
			if (curNode != null) {
				System.out.println(curNode);
				stack.push(curNode);
				curNode = curNode.left;
			} else {
				if (stack.isEmpty()) return;
				Node<E>node = stack.pop();
				curNode = node.right;
			}
		}
	}

	public void inorderTraversal() {
		Stack<Node<E>> stack = new Stack<>();
		Node<E>curNode = root;
		while (true) {
			if (curNode != null) {
				stack.push(curNode);
				curNode = curNode.left;
			}else {
				if (stack.isEmpty()) return;
				Node<E>node = stack.pop();
				System.out.println(node);
				curNode = node.right;
			}
		}
	}

    public void postorderTraversal() {
		Stack<Node<E>> stack = new Stack<>();
		Node<E>node = root;
		stack.push(node);
		// - 这里的lastNode 初始值不能是null, 否则 lastNode == node.left || lastNode == node.right 的判断就会出现问题.
		Node<E>lastNode = root;
		while (!stack.isEmpty()) {
			node = stack.peek();
			if (node.isLeaf() || lastNode == node.left || lastNode == node.right) {
				System.out.println(node);
				stack.pop();
				lastNode = node;
			}else {
				stack.push(node.right);
				stack.push(node.left);
			}
		};
	}

    // - 反转二叉树
	public void reverseTree() {
		Queue<Node<E>>queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			Node<E>curNode = queue.poll();
			if (curNode.left != null) {
				queue.offer(curNode.left);
			}
			if (curNode.right != null) {
				queue.offer(curNode.right);
			}
			// - 到这里说明curNode的左右子节点都遍历过了.
			Node<E>tempNode = curNode.left;
			curNode.left = curNode.right;
			curNode.right = tempNode;
		}
	}
    // - 二叉树的高度
    public int height() {
		if (root == null) return 0;
		int height = 0;
		Queue<Node<E>>queue = new LinkedList<>();
		queue.offer(root);
		int  levelSize = queue.size();
		
		while (!queue.isEmpty()) {
			Node<E>node = queue.poll();
			levelSize --;
			
			if(node.left != null) {
				queue.offer(node.left);
			}
			if (node.right != null) {
				queue.offer(node.right);
			}
			
			if (levelSize == 0) {
				levelSize = queue.size();
				height++;
			}
		}
		
		return height;
	}





    
    public void preorder(Visitor<E> visitor) {
		if (visitor == null || root == null) return;
		Stack<Node<E>> stack = new Stack<>();
		stack.push(root);
		while (!stack.isEmpty()) {
			Node<E> node = stack.pop();
			// 访问node节点
			if (visitor.visit(node.element)) return;
			if (node.right != null) {
				stack.push(node.right);
			}
			if (node.left != null) {
				stack.push(node.left);
			}
		}
	}

    public void inorder(Visitor<E> visitor) {
		if (visitor == null || root == null) return;
		Node<E> node = root;
		Stack<Node<E>> stack = new Stack<>();
		while (true) {
			if (node != null) {
				stack.push(node);
				// 向左走
				node = node.left;
			} else if (stack.isEmpty()) {
				return;
			} else {
				node = stack.pop();
				// 访问node节点
				if (visitor.visit(node.element)) return;
				// 让右节点进行中序遍历
				node = node.right;
			}
		}
	}

	public void postorder(Visitor<E> visitor) {
		if (visitor == null || root == null) return;
		// 记录上一次弹出访问的节点
		Node<E> prev = null;
		Stack<Node<E>> stack = new Stack<>();
		stack.push(root);
		while (!stack.isEmpty()) {
			Node<E> top = stack.peek();
			if (top.isLeaf() || (prev != null && prev.parent == top)) {
				prev = stack.pop();
				// 访问节点
				if (visitor.visit(prev.element)) return;
			} else {
				if (top.right != null) {
					stack.push(top.right);
				}
				if (top.left != null) {
					stack.push(top.left);
				}
			}
		}
	}
	
	public void levelOrder(Visitor<E> visitor) {
		if (root == null || visitor == null) return;
		
		Queue<Node<E>> queue = new LinkedList<>();
		queue.offer(root);
		
		while (!queue.isEmpty()) {
			Node<E> node = queue.poll();
			if (visitor.visit(node.element)) return;
			
			if (node.left != null) {
				queue.offer(node.left);
			}
			
			if (node.right != null) {
				queue.offer(node.right);
			}
		}
	}
}