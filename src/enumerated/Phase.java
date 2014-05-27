package enumerated;

import java.util.EnumMap;
import java.util.Map;

//EnumMap的用法
public enum Phase {
	SOLID, LIQUID, GAS; //固态、液态、气态
	
	public enum Transition {
		MELT(SOLID,LIQUID), FREEZE(LIQUID,SOLID), //融化，固化
		BOIL(LIQUID,GAS), CONDENSE(GAS,LIQUID), //蒸发，液化
		SUBLIME(SOLID,GAS), DEPOSIT(GAS,SOLID); //气化，凝华
		
		private final Phase src;
		private final Phase dst;
		Transition(Phase src, Phase dst) {
			this.src = src;
			this.dst = dst;
		}
		
		private static final Map<Phase, Map<Phase, Transition>> m = 
				new EnumMap<Phase, Map<Phase, Transition>>(Phase.class);
		static {
			for(Phase phase : Phase.values()) {
				m.put(phase, new EnumMap<Phase,Transition>(Phase.class));
			}
			for(Transition transition: Transition.values()) {
				m.get(transition.src).put(transition.dst, transition);
			}
		}
		public static Transition from(Phase src, Phase dst) {
			return m.get(src).get(dst);
		}
	}
}
