package mpdev.compilerv3.chapter_xa_01

/** code module interface - defines the functions needed to generate assembly code */
interface CodeModule {
    val COMMENT: String
    var stackVarOffset: Int

    val funInpParamsCpuRegisters: Array<String>
    val funTempParamsCpuRegisters: Array<String>
    val MAX_FUN_PARAMS: Int

    val INT_SIZE: Int
    val STRPTR_SIZE: Int

    fun getOutputLines(): Int

    fun outputCode(s: String)
    fun outputCodeNl(s: String = "")
    fun outputCodeTab(s: String)
    fun outputCodeTabNl(s: String)
    fun outputComment(s: String)
    fun outputCommentNl(s: String)
    fun outputLabel(s: String)

    /** initialisation code for assembler */
    fun progInit(progName: String)
    /** declare int variable */
    fun declareInt(varName: String, initValue: String)
    /** initial code for functions */
    fun funInit()
    /** declare function */
    fun declareAsmFun(name: String)
    /** transfer a function parameter to stack variable */
    fun storeFunParamToStack(paramIndx: Int, stackOffset: Int)
    /** set a temporary function param register to the value of %rax (the result of the last expression) */
    fun setIntTempFunParam(paramIndx: Int)
    /** set a function input param register from the temporary register */
    fun setFunParamReg(paramIndx: Int)
    /** restore a function input param register */
    fun restoreFunTempParamReg(paramIndx: Int)
    /** initial code for main */
    fun mainInit()
    /** termination code for assembler */
    fun mainEnd()
    /** allocate variable space in the stack - returns the new stack offset for this new variable */
    fun allocateStackVar(size: Int): Int
    /** release variable space in the stack */
    fun releaseStackVar(size: Int)
    /** initiliase an int stack var */
    fun initStackVarInt(stackOffset : Int, initValue: String)
    /** exit the program */
    fun exitProgram()

    /** set accumulator to a value */
    fun setAccumulator(value: String)
    /** clear accumulator */
    fun clearAccumulator()
    /** increment accumulator */
    fun incAccumulator()
    /** decrement accumulator */
    fun decAccumulator()
    /** push accumulator to the stack */
    fun saveAccumulator()
    /** add top of stack to accumulator */
    fun addToAccumulator()
    /** subtract top of stack from accumulator */
    fun subFromAccumulator()
    /** negate accumulator */
    fun negateAccumulator()
    /** multiply accumulator by top of stack */
    fun multiplyAccumulator()
    /** divide accumulator by top of stack */
    fun divideAccumulator()
    /** set accumulator to variable */
    fun setAccumulatorToVar(identifier: String)
    /** set accumulator to local variable */
    fun setAccumulatorToLocalVar(offset: Int)
    /** call a function */
    fun callFunction(subroutine: String)
    /** return from function */
    fun returnFromCall()
    /** set variable to accumulator */
    fun assignment(identifier: String)
    /** set stack variable to accumulator */
    fun assignmentLocalVar(offset: Int)

    /** branch if false */
    fun jumpIfFalse(label: String)
    /** branch */
    fun jump(label: String)

    /** boolean not accumulator */
    fun booleanNotAccumulator()
    /** or top of stack with accumulator */
    fun orAccumulator()
    /** exclusive or top of stack with accumulator */
    fun xorAccumulator()
    /** and top of stack with accumulator */
    fun andAccumulator()

    /** compare and set accumulator and flags - is equal to */
    fun compareEquals()
    /** compare and set accumulator and flags - is not equal to */
    fun compareNotEquals()
    /** compare and set accumulator and flags - is less than */
    fun compareLess()
    /** compare and set accumulator and flags - is less than */
    fun compareLessEqual()
    /** compare and set accumulator and flags - is greater than */
    fun compareGreater()
    /** compare and set accumulator and flags - is greater than */
    fun compareGreaterEqual()

    /** print a newline */
    fun printNewline()
    /** print accumulator as integer */
    fun printInt()
    /** read global int var into variable */
    fun readInt(identifier: String)
    /** read local int var into variable */
    fun readIntLocal(stackOffset: Int)

    /** end of program */
    fun progEnd()

    ////////// string operations ///////////////////////
    /** declare string global variable */
    fun declareString(varName: String, initValue: String, length: Int = 0)
    /** initialise a str stack var */
    fun initStackVarString(stackOffset: Int, stringDataOffset: Int, constStrAddress: String)
    /** get address of string variable in accumulator */
    fun getStringVarAddress(identifier: String)
    /** save acc string to buffer and address in stack - acc is pointer */
    fun saveString()
    /** add acc string to buf string - both are pointers*/
    fun addString()
    /** set string variable from accumulator (var and acc are pointers */
    fun assignmentString(identifier: String)
    /** set string variable from accumulator (var and acc are pointers */
    fun assignmentStringLocalVar(stackOffset: Int)
    /** print string - address in accumulator */
    fun printStr()
    /** read string into global variable - address in accumulator*/
    fun readString(identifier: String, length: Int)
    /** read string into local variable - address in accumulator*/
    fun readStringLocal(stackOffset: Int, length: Int)
    /** compare 2 strings for equality */
    fun compareStringEquals()
    /** compare 2 strings for non-equality */
    fun compareStringNotEquals()
    /** string constants */
    fun stringConstantsDataSpace()
    //////////////////////////////////////////////////////////
    /** dummy instruction */
    fun dummyInstr(cmd: String)
}
